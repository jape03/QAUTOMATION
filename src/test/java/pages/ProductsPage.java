package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class ProductsPage {
    private final WebDriver driver;
    private final Waits waits;

    private final By title = By.className("title");
    private final By cartIcon = By.className("shopping_cart_link");

    // Example item: Sauce Labs Backpack
    private final By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public String getTitle() {
        return waits.visible(title).getText();
    }

    public ProductsPage addBackpackToCart() {
        waits.clickableAndClick(addBackpackBtn);
        return this;
    }

    public CartPage goToCart() {
        waits.clickableAndClick(cartIcon);
        return new CartPage(driver);
    }
}
