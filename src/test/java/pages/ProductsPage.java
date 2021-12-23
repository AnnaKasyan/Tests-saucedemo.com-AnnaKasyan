package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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

    @Override
    public boolean isPageOpened() {
        return isElementPresent(SHOPPING_CART);
    }

    @Override
    public ProductsPage open() {
        waitUntilElementVisible(By.cssSelector(".peek"));
        return this;
    }

    @Step("Product name: {}")
    private WebElement getItemContainer(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item']"));
    }

    @Step("Opening product details page")
    public void openProductDetails(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(PRODUCT_NAME_LOCATOR).click();
        log.info("click product name link");
    }

    @Step("Getting product price")
    public String getProductPrice(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(PRICE_LOCATOR).getText();
    }

    @Step("Getting product description")
    public String getProductDescription(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(DESCRIPTION_LOCATOR).getText();
    }

    @Step("Clicking 'Add to cart' button")
    public ProductsPage clickAddToCartButton(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(ADD_TO_CART_BUTTON).click();
        log.info("click add to cart button");
        return this;
    }

    @Step("Clicking Shopping Cart link")
    public CartPage openShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
        log.info("click shopping cart link");
        return new CartPage(driver);
    }

    @Step("Clicking 'Back to products' button")
    public void clickBackToProducts() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
        log.info("click back to products button");
    }
}
