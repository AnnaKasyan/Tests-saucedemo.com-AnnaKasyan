package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final static By PRICE_LOCATOR = By.cssSelector(".inventory_item_price");
    private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart-]");
    private final static By PRODUCT_NAME_LOCATOR = By.cssSelector(".inventory_item_name");
    private final static By DESCRIPTION_LOCATOR = By.cssSelector(".inventory_item_desc");
    private final static By BACK_TO_PRODUCTS_BUTTON = By.cssSelector("button[id=back-to-products]");
    private final static By SHOPPING_CART = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getItemContainer(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item']"));
    }

    public void openProductDetails(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(PRODUCT_NAME_LOCATOR).click();
    }

    public String getProductPrice(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(PRICE_LOCATOR).getText();
    }

    public String getProductDescription(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(DESCRIPTION_LOCATOR).getText();
    }

    public ProductsPage clickAddToCartButton(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public CartPage openShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
        return new CartPage(driver);
    }

    public void clickBackToProducts() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }
}
