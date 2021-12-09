package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final static By SHOPPING_CART = By.cssSelector(".shopping_cart_link");
    private final static By PRODUCT_NAME_LOCATOR = By.cssSelector(".inventory_item_name");
    private final static By PRICE_LOCATOR = By.cssSelector(".inventory_item_price");
    private final static By DESCRIPTION_LOCATOR = By.cssSelector(".inventory_item_desc");
    private final static By CONTINUE_SHOPPING_BUTTON = By.cssSelector("[data-test=continue-shopping]");
    private final static By CHECKOUT_BUTTON = By.cssSelector("[data-test=checkout]");
    private final static By REMOVE_BUTTON = By.cssSelector("button[id^=remove-sauce-]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Shopping Cart page is opened")
    public boolean isPageOpened() {
        return isElementPresent(CONTINUE_SHOPPING_BUTTON);
    }

    @Override
    @Step("Opening Shopping Cart page")
    public CartPage open() {
        waitUntilElementVisible(CHECKOUT_BUTTON);
        return this;
    }

    @Step("Clicking Shopping Cart link")
    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }

    @Step("Clicking 'Continue shopping' button")
    public ProductsPage clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Clicking 'Checkout' button")
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Clicking 'Remove' button")
    public CartPage clickRemoveButton(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(REMOVE_BUTTON).click();
        return this;
    }

    private WebElement getItemContainer(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]/ancestor::div[@class='cart_item_label']"));
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

    @Step("Product name is displayed")
    public boolean isProductNameDisplayed(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(PRODUCT_NAME_LOCATOR).isDisplayed();
    }

    @Step("Getting products count")
    public int getProductsCount() {
        List<WebElement> itemCount = driver.findElements(By.cssSelector(".cart_item"));
        return itemCount.size();
    }
}
