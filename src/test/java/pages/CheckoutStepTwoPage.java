package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class CheckoutStepTwoPage {
    private final WebDriver driver;
    private final Waits waits;

    private final By title = By.className("title");
    private final By finishBtn = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public String getTitle() {
        return waits.visible(title).getText();
    }

    public CheckoutCompletePage clickFinish() {
        waits.clickableAndClick(finishBtn);
        return new CheckoutCompletePage(driver);
    }
}
