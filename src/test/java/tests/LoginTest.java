package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.Waits;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccess() {
        driver.get("https://www.saucedemo.com/");

        Waits w = new Waits(driver);

        w.visible(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Assert we are on Products page
        String header = w.visible(By.className("title")).getText();
        Assert.assertEquals(header, "Products");
    }

    @Test
    public void loginInvalidPasswordShowsError() {
        driver.get("https://www.saucedemo.com/");

        Waits w = new Waits(driver);

        w.visible(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        String error = w.visible(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.toLowerCase().contains("username and password do not match"));
    }
}
