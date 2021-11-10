package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BuyTest extends BaseTest {

    @Test
    public void buyTest() {
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement backpack = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        backpack.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]"));
        addToCartButton.click();
        WebElement shoppingCart = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCart.click();
        WebElement itemName = driver.findElement(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals(itemName.getText(), "Sauce Labs Backpack");
        WebElement itemPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(itemPrice.getText(), "$29.99");
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Peter");
        WebElement lastName = driver.findElement(By.cssSelector("[data-test=lastName]"));
        lastName.sendKeys("Parker");
        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));
        postalCode.sendKeys("1111");
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        finishButton.click();
        WebElement thanksMessage = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
        Assert.assertTrue(thanksMessage.isDisplayed());
    }
}
