package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void addToCartAndCheckoutSuccess() {
        // Login
        LoginPage login = new LoginPage(driver).open();
        login.login("standard_user", "secret_sauce");

        // Products
        ProductsPage products = new ProductsPage(driver);
        Assert.assertEquals(products.getTitle(), "Products");

        // Add item + go to cart
        products.addBackpackToCart();
        CartPage cart = products.goToCart();
        Assert.assertEquals(cart.getTitle(), "Your Cart");
        Assert.assertTrue(cart.getItemName().toLowerCase().contains("backpack"));

        // Checkout step 1
        CheckoutStepOnePage step1 = cart.clickCheckout();
        step1.fillInfo("Jayyy", "QA", "1000");

        // Checkout step 2 + finish
        CheckoutStepTwoPage step2 = step1.clickContinue();
        if (step1.isOnStepOne()) {
        Assert.fail("Still on Step One. Error: " + step1.getErrorMessageIfAny());
        }
        Assert.assertEquals(step2.getTitle(), "Checkout: Overview");

        CheckoutCompletePage done = step2.clickFinish();
        Assert.assertEquals(done.getTitle(), "Checkout: Complete!");
        Assert.assertTrue(done.getCompleteHeader().toLowerCase().contains("thank you"));

        
    }
}

