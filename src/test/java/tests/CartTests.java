package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTests extends BaseTest {

    private final static String CART_PAGE_URL = "https://www.saucedemo.com/cart.html";
    private final static String BACKPACK_ITEM_NAME = "Sauce Labs Backpack";
    private final static String FLEECE_JACKET_ITEM_NAME = "Sauce Labs Fleece Jacket";
    private final static String BOLT_T_SHIRT_ITEM_NAME = "Sauce Labs Bolt T-Shirt";
    private final static String ONESIE_ITEM_NAME = "Sauce Labs Onesie";
    protected ProductsPage productsPage;
    protected CartPage cartPage;

    @BeforeMethod
    public void navigate() {
        loginPage.open().login(USERNAME, PASSWORD);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void clearSession() {
        driver.manage().deleteAllCookies();
    }


    @Test
    public void cartPositiveTest() {
        productsPage.clickAddToCartButton(BACKPACK_ITEM_NAME);
        cartPage.openShoppingCart();
        Assert.assertTrue(cartPage.isProductNameDisplayed(BACKPACK_ITEM_NAME));
        cartPage.clickContinueShoppingButton();
        Assert.assertFalse(Boolean.parseBoolean(productsPage.getCurrentPageUrl()), CART_PAGE_URL);
        productsPage.clickAddToCartButton(FLEECE_JACKET_ITEM_NAME);
        cartPage.openShoppingCart();
        Assert.assertTrue(cartPage.isProductNameDisplayed(BACKPACK_ITEM_NAME));
        Assert.assertTrue(cartPage.isProductNameDisplayed(FLEECE_JACKET_ITEM_NAME));
        Assert.assertEquals(cartPage.getProductsCount(), 2);
        cartPage.clickRemoveButton(BACKPACK_ITEM_NAME);
        Assert.assertTrue(cartPage.isProductNameDisplayed(FLEECE_JACKET_ITEM_NAME));
        Assert.assertEquals(cartPage.getProductsCount(), 1);
        cartPage.clickCheckoutButton();
        Assert.assertNotEquals(productsPage.getCurrentPageUrl(), CART_PAGE_URL);
    }

    @Test
    public void cartPositiveTest2() {
        productsPage.clickAddToCartButton(BACKPACK_ITEM_NAME)
                .clickAddToCartButton(FLEECE_JACKET_ITEM_NAME)
                .clickAddToCartButton(ONESIE_ITEM_NAME)
                .openShoppingCart()
                .clickRemoveButton(ONESIE_ITEM_NAME)
                .clickRemoveButton(FLEECE_JACKET_ITEM_NAME)
                .clickContinueShoppingButton()
                .clickAddToCartButton(BOLT_T_SHIRT_ITEM_NAME)
                .openShoppingCart()
                .getProductsCount();
        Assert.assertEquals(cartPage.getProductsCount(), 2);
    }
}
