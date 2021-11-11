package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTests extends BaseTest{

    @BeforeMethod
    public void navigate() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void clearSession() {
        driver.manage().deleteAllCookies();
    }

    protected ProductsPage productsPage;
    protected CartPage cartPage;
    private final static String CART_PAGE_URL = "https://www.saucedemo.com/cart.html";
    private final static String ITEM1 = "Sauce Labs Backpack";
    private final static String ITEM2 = "Sauce Labs Fleece Jacket";

    @Test
    public void cartPositiveTest() {
        productsPage.clickAddToCartButton(ITEM1);
        cartPage.openShoppingCart();
        Assert.assertTrue(cartPage.isProductNameDisplayed(ITEM1));
        cartPage.clickContinueShoppingButton();
        Assert.assertFalse(Boolean.parseBoolean(productsPage.getCurrentPageUrl()), CART_PAGE_URL);
        productsPage.clickAddToCartButton(ITEM2);
        cartPage.openShoppingCart();
        Assert.assertTrue(cartPage.isProductNameDisplayed(ITEM1));
        Assert.assertTrue(cartPage.isProductNameDisplayed(ITEM2));
        cartPage.clickRemoveButton(ITEM1);
        Assert.assertFalse(cartPage.isProductNameDisplayed(ITEM1));
        Assert.assertTrue(cartPage.isProductNameDisplayed(ITEM2));
        cartPage.clickCheckoutButton();
        Assert.assertFalse(Boolean.parseBoolean(productsPage.getCurrentPageUrl()), CART_PAGE_URL);
    }
}
