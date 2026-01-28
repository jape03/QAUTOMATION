package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void openPageAndCheckTitle() {
        driver.get("https://the-internet.herokuapp.com/");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("the internet"));
    }
}
