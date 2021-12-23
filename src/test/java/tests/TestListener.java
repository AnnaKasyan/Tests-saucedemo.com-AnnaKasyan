package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    protected WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test '%s' succeed%n", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf("Test '%s' failed%n", result.getName());
        WebDriver driver = (WebDriver) (result.getTestContext().getAttribute("driver"));
        AllureUtils.attachScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.printf("Test '%s' skipped%n", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}


