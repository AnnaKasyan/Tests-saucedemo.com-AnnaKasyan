package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Locators extends BaseTest {


    public void locators() {

        //id
        WebElement loginButton = driver.findElement(By.id("login-button"));  //login page
        //name
        WebElement userName = driver.findElement(By.name("user-name"));  //login page
        //classname
        WebElement sortContainer = driver.findElement(By.className("product_sort_container"));  //inventory page
        //tagname
        WebElement backHomeButton = driver.findElement(By.tagName("button"));  //checkout-complete page
        //linktext
        WebElement jacket = driver.findElement(By.linkText("Sauce Labs Fleece Jacket"));  //inventory page
        //partiallinktext
        WebElement fleeceJacket = driver.findElement(By.partialLinkText("Fleece Jacket"));  //inventory page
        //xpath
        //Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));  //login page
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));  //login page
        //Поиск по тексту, например By.xpath("//tag[text()='text']");
        WebElement thanksMessage = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));   //checkout-complete page

        //Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");

        //Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        WebElement usernames = driver.findElement(By.xpath("//h4[contains(text(),'Accepted usernames are:')]"));  //login page
        WebElement backpack = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));   //inventory page

        //ancestor, например //*[text()='Enterprise Testing']//ancestor::div

        //descendant

        //following (false)
        WebElement textAboutBackpack = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]/following-sibling::div[@class='inventory_details_desc large_size']"));  //cart page

        //parent

        //preceding (false)
        WebElement priceBackpack = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack')]/preceding-sibling::div[@class='inventory_details_price']"));  //cart page
        //*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        WebElement continueShoppingButton = driver.findElement(By.xpath("//div[@class='btn btn_secondary back btn_medium' and @name='continue-shopping']")); //cart page
        //css
        //.class
        WebElement passwordForAllUsers = driver.findElement(By.cssSelector(".login_password")); //login page

        //.class1.class2

        //.class1 .class2
        WebElement shoppingCart = driver.findElement(By.cssSelector(".shopping_cart_container .shopping_cart_link"));  //inventory page
        //#id
        WebElement shoppingCartOther = driver.findElement(By.cssSelector("#logout_sidebar_link"));  //inventory page
        //tagname
        WebElement productName = driver.findElement(By.cssSelector("a"));  //cart page
        //tagname.class
        WebElement shoppingCartOtherMetod = driver.findElement(By.cssSelector("a.shopping_cart_link")); //inventory-item page
        //[attribute=value]
        WebElement checkoutButton = driver.findElement(By.cssSelector("[data-test=checkout]")); //cart page
        //[attribute~=value]
        WebElement removeButton = driver.findElement(By.cssSelector("[id~=remove-sauce-labs-backpack]")); //cart page
        //[attribute|=value] (false)
        WebElement firstName = driver.findElement(By.cssSelector("[placeholder|=First]")); //checkout-step-one page
        //[attribute^=value]
        WebElement facebookLink = driver.findElement(By.cssSelector("a[href^='https://www.facebook.']")); //inventory page
        //[attribute$=value]
        WebElement menuAbout = driver.findElement(By.cssSelector("[a[href$='com/']")); //inventory page
        //[attribute*=value]
        WebElement menu = driver.findElement(By.cssSelector("[a[href*='#']"));  //inventory page
    }
}
