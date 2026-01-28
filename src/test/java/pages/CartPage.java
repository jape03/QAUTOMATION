package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class CartPage {
    private final WebDriver driver;
    private final Waits waits;

    private final By cartTitle = By.className("title");
    private final By checkoutBtn = By.id("checkout");

    // Backpack item name in cart
    private final By itemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public String getTitle() {
        return waits.visible(cartTitle).getText();
    }

    public String getItemName() {
        return waits.visible(itemName).getText();
    }

    public CheckoutStepOnePage clickCheckout() {
        waits.clickableAndClick(checkoutBtn);
        return new CheckoutStepOnePage(driver);
    }
}
