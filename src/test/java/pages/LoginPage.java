package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class LoginPage {
    private final WebDriver driver;
    private final Waits waits;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        waits.visible(username);
        return this;
    }

    public LoginPage typeUsername(String value) {
        waits.visible(username).clear();
        waits.visible(username).sendKeys(value);
        return this;
    }

    public LoginPage typePassword(String value) {
        waits.visible(password).clear();
        waits.visible(password).sendKeys(value);
        return this;
    }

    public void clickLogin() {
        waits.clickableAndClick(loginBtn);
    }

    public void login(String user, String pass) {
        typeUsername(user);
        typePassword(pass);
        clickLogin();
    }

    public String getError() {
        return waits.visible(errorMsg).getText();
    }
}
