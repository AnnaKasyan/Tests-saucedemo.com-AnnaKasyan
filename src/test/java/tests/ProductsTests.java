package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class ProductsTests extends BaseTest {

    private final static String BACKPACK_ITEM_NAME = "Sauce Labs Backpack";
    private final static String BACKPACK_ITEM_PRICE = "$29.99";
    private final static String BACKPACK_ITEM_DESCRIPTION = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    private final static String FLEECE_JACKET_ITEM_NAME = "Sauce Labs Fleece Jacket";
    private final static String FLEECE_JACKET_ITEM_PRICE = "$49.99";
    private final static String FLEECE_JACKET_ITEM_DESCRIPTION = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
    protected ProductsPage productsPage;
    protected CartPage cartPage;

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

    @Test
    public void item1PositiveTest() {
        Assert.assertEquals(productsPage.getProductPrice(BACKPACK_ITEM_NAME), BACKPACK_ITEM_PRICE);
        Assert.assertEquals(productsPage.getProductDescription(BACKPACK_ITEM_NAME), BACKPACK_ITEM_DESCRIPTION);
        productsPage.openProductDetails(BACKPACK_ITEM_NAME);
        productsPage.clickBackToProducts();
        productsPage.clickAddToCartButton(BACKPACK_ITEM_NAME);
        cartPage.openShoppingCart();
        Assert.assertEquals(cartPage.getProductPrice(BACKPACK_ITEM_NAME), BACKPACK_ITEM_PRICE);
        Assert.assertEquals(cartPage.getProductDescription(BACKPACK_ITEM_NAME), BACKPACK_ITEM_DESCRIPTION);
    }

    @Test
    public void item2PositiveTest() {
        Assert.assertEquals(productsPage.getProductPrice(FLEECE_JACKET_ITEM_NAME), FLEECE_JACKET_ITEM_PRICE);
        Assert.assertEquals(productsPage.getProductDescription(FLEECE_JACKET_ITEM_NAME), FLEECE_JACKET_ITEM_DESCRIPTION);
        productsPage.openProductDetails(FLEECE_JACKET_ITEM_NAME);
        productsPage.clickBackToProducts();
        productsPage.clickAddToCartButton(FLEECE_JACKET_ITEM_NAME);
        cartPage.openShoppingCart();
        Assert.assertEquals(cartPage.getProductPrice(FLEECE_JACKET_ITEM_NAME), FLEECE_JACKET_ITEM_PRICE);
        Assert.assertEquals(cartPage.getProductDescription(FLEECE_JACKET_ITEM_NAME), FLEECE_JACKET_ITEM_DESCRIPTION);
    }
}

