package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Login page is opened")
    public boolean isPageOpened() {
        return isElementPresent(LOGIN_BUTTON);
    }

    @Override
    @Step("Opening Login page")
    public LoginPage open() {
        driver.get(URL);
        waitUntilElementVisible(USERNAME_INPUT);
        return this;
    }

    @Step("Login to Saucedemo.com with username {username} and password {password}")
    public ProductsPage login(String username, String password) {
        setUsernameInput(username);
        setPasswordInput(password);
        clickLoginButton();
        return new ProductsPage(driver);
    }

    @Step("Setting username value: {username}")
    public LoginPage setUsernameInput(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        return this;
    }

    @Step("Setting password value: {password}")
    public LoginPage setPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Clicking Login button")
    public LoginPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }
}
