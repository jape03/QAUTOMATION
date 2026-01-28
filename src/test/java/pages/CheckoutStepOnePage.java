package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class CheckoutStepOnePage {

    private final WebDriver driver;
    private final Waits waits;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By title = By.className("title");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
        waits.visible(title);
    }

   public CheckoutStepOnePage fillInfo(String fn, String ln, String zip) {
    waits.visible(firstName).clear();
    waits.visible(firstName).sendKeys(fn);

    waits.visible(lastName).clear();
    waits.visible(lastName).sendKeys(ln);

    waits.visible(postalCode).clear();
    waits.visible(postalCode).sendKeys(zip);

    return this;
}


    public CheckoutStepTwoPage clickContinue() {
        waits.clickableAndClick(continueBtn);

        // Wait for Step Two page title (Overview) to appear
        return new CheckoutStepTwoPage(driver);
    }

    public boolean isOnStepOne() {
    return waits.visible(title).getText().equals("Checkout: Your Information");
}

    public String getErrorMessageIfAny() {
    try {
        return waits.visible(errorMsg).getText();
    } catch (Exception e) {
        return "";
    }
}
}
