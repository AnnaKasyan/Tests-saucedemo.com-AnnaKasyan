package tests;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    final static String USERNAME = "standard_user";
    final static String PASSWORD = "secret_sauce";
    protected WebDriver driver;
    protected LoginPage loginPage;


    @Parameters({"browser"})
    @BeforeClass(description = "Open browser", alwaysRun = true)
    @Step("Opening browser")
    public void setUp(ITestContext testContext, @Optional("chrome") String browser) {
        System.getProperty("browser");
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    @Step("Closing browser")
    public void tearDown() {
        driver.quit();
    }
}
