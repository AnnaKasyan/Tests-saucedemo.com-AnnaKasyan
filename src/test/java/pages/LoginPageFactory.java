package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test=er ror]")
    private WebElement errorMessage;


    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public LoginPage open() {
        driver.get(URL);
        return new LoginPage(driver);
    }

    @Step("Login to Saucedemo.com with username {username} and password {password}")
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        waitForPasswordInputClickable();
        passwordInput.sendKeys(password);
        waitUntilElementClickable(loginButton);
        loginButton.click();
    }

    public void waitForPasswordInputClickable() {
        waitUntilElementClickable(passwordInput);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

}


