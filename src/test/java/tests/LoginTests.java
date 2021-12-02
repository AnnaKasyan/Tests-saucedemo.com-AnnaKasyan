package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private final static String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    private final static String INVALID_USERNAME = "user";
    private final static String INVALID_PASSWORD = "1111";

    @BeforeMethod
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod
    public void clearSession() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "SauceDemo login positive test", groups = {"Smoke"},retryAnalyzer = RetryAnalyzer.class)
    public void loginPositiveTest() {
        loginPage.login(USERNAME, PASSWORD);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(loginPage.getCurrentPageUrl(), expectedUrl);
    }

    @Test(description = "SauceDemo login negative test",  groups = {"Negative"}, dataProvider = "Negative Login Test Data")
    public void loginNegativeTest(String username, String password, String expectedErrorMessage) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    @DataProvider(name = "Negative Login Test Data")
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "", "Epic sadface: Username is required"},
        };
    }

    @Test(description = "SauceDemo login with invalid fields test")
    public void loginWithInvalidFieldsTest() {
        String expected_error_message = "Epic sadface: Username and password do not match any user in this service";
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        Assert.assertEquals(loginPage.getCurrentPageUrl(), LOGIN_PAGE_URL);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expected_error_message);
    }

    @Test(description = "SauceDemo login with empty fields test", invocationCount = 4, threadPoolSize = 2)
    public void loginWithEmptyFieldsTest() {
        String errorMessage = loginPage.open()
                .setUsernameInput("")
                .setPasswordInput("")
                .clickLoginButton()
                .getErrorMessageText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }
}
