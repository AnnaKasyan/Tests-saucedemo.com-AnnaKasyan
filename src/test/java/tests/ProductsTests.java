package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class ProductsTests extends BaseTest {

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
    private final static String URL = "https://www.saucedemo.com/inventory.html";
    private final static String ITEM1 = "Sauce Labs Backpack";
    private final static String PRICE_ITEM1 = "$29.99";
    private final static String DESCRIPTION_ITEM1 = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    private final static String ITEM2 = "Sauce Labs Fleece Jacket";
    private final static String PRICE_ITEM2 = "$49.99";
    private final static String DESCRIPTION_ITEM2 = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";

    @Test
    public void item1PositiveTest() {
        Assert.assertEquals(productsPage.getProductPrice(ITEM1), PRICE_ITEM1);
        Assert.assertEquals(productsPage.getProductDescription(ITEM1), DESCRIPTION_ITEM1);
        productsPage.openProductDetails(ITEM1);
        Assert.assertFalse(Boolean.parseBoolean(productsPage.getCurrentPageUrl()), URL);
        driver.navigate().back();
        productsPage.clickAddToCartButton(ITEM1);
        cartPage.openShoppingCart();
        Assert.assertEquals(cartPage.getProductPrice(ITEM1), PRICE_ITEM1);
        Assert.assertEquals(cartPage.getProductDescription(ITEM1), DESCRIPTION_ITEM1);
    }

    @Test
    public void item2PositiveTest() {
        Assert.assertEquals(productsPage.getProductPrice(ITEM2), PRICE_ITEM2);
        Assert.assertEquals(productsPage.getProductDescription(ITEM2), DESCRIPTION_ITEM2);
        productsPage.openProductDetails(ITEM2);
        Assert.assertFalse(Boolean.parseBoolean(productsPage.getCurrentPageUrl()), URL);
        driver.navigate().back();
        productsPage.clickAddToCartButton(ITEM2);
        cartPage.openShoppingCart();
        Assert.assertEquals(cartPage.getProductPrice(ITEM2), PRICE_ITEM2);
        Assert.assertEquals(cartPage.getProductDescription(ITEM2), DESCRIPTION_ITEM2);
    }
}

