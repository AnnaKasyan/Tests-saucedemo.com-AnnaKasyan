package pages;

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

    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }

    public ProductsPage clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public CartPage clickRemoveButton(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        itemContainer.findElement(REMOVE_BUTTON).click();
        return this;
    }

    private WebElement getItemContainer(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]/ancestor::div[@class='cart_item_label']"));
    }

    public String getProductPrice(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(PRICE_LOCATOR).getText();
    }

    public String getProductDescription(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(DESCRIPTION_LOCATOR).getText();
    }

    public boolean isProductNameDisplayed(String productName) {
        WebElement itemContainer = getItemContainer(productName);
        return itemContainer.findElement(PRODUCT_NAME_LOCATOR).isDisplayed();
    }

    public int getProductsCount() {
        List<WebElement> itemCount = driver.findElements(By.cssSelector(".cart_item"));
        return itemCount.size();
    }
}
