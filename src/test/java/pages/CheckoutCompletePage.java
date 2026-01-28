package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class CheckoutCompletePage {
    private final WebDriver driver;
    private final Waits waits;

    private final By title = By.className("title");
    private final By completeHeader = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public String getTitle() {
        return waits.visible(title).getText();
    }

    public String getCompleteHeader() {
        return waits.visible(completeHeader).getText();
    }
}
