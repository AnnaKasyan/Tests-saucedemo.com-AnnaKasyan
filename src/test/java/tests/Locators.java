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
        WebElement userNameOtherMethod = driver.findElement(By.xpath("//input[contains(@data-test,'password')]"));  //login page
        WebElement menuButton = driver.findElement(By.xpath("//button[contains(@id,'react-burger-menu-btn')]"));  //inventory page
        //Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        WebElement usernames = driver.findElement(By.xpath("//h4[contains(text(),'Accepted usernames are:')]"));  //login page
        WebElement backpack = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));   //inventory page
        //ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        WebElement informProduct = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Fleece Jacket')]/ancestor::div[@class='inventory_item']")); //cart page
        WebElement cartList = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_list']")); //cart page
        //descendant
        WebElement twitterLink = driver.findElement(By.xpath("//ul[@class='social']//descendant::li[@class='social_twitter']")); //inventory page
        //following
        WebElement textAboutBackpack = driver.findElement(By.xpath("//a[@id='item_4_title_link']/following-sibling::div[@class='inventory_item_desc']"));  //inventory page
        WebElement priceLowToHigh = driver.findElement(By.xpath("//span[@class='active_option']//following::option[contains(text(),'Price (low to high)')]"));  //inventory page
        //parent
        WebElement menuList = driver.findElement(By.xpath("//a[@class='bm-item menu-item']//parent::nav"));  //inventory page
        WebElement socialLink = driver.findElement(By.xpath("//li[@class='social_linkedin']//parent::ul"));  //inventory page
        //preceding
        WebElement priceBackpack = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack')]/preceding-sibling::div[@class='inventory_details_price']"));  //cart page
        //*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        WebElement continueShoppingButton = driver.findElement(By.xpath("//div[@class='btn btn_secondary back btn_medium' and @name='continue-shopping']")); //cart page
        //css
        //.class
        WebElement passwordForAllUsers = driver.findElement(By.cssSelector(".login_password")); //login page
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
        WebElement linkedinLink = driver.findElement(By.cssSelector("[class|=social_linkedin]")); //inventory page
        //[attribute^=value]
        WebElement facebookLink = driver.findElement(By.cssSelector("a[href^='https://www.facebook.']")); //inventory page
        //[attribute$=value]
        WebElement menuAbout = driver.findElement(By.cssSelector("[a[href$='com/']")); //inventory page
        //[attribute*=value]
        WebElement menu = driver.findElement(By.cssSelector("[a[href*='#']"));  //inventory page
    }
}
