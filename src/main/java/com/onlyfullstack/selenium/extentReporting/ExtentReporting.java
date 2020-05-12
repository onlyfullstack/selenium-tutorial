package com.onlyfullstack.selenium.extentReporting;

import com.onlyfullstack.selenium.utils.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ExtentReporting {

    WebDriver webDriver;

    ExtentReports extent;
    ExtentTest extentTestObject;

    @BeforeClass
    public void setup() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        extent = new ExtentReports ("target/extent-test-report/RegressionSignOff.html", true);

        extent.addSystemInfo("Host Name", "Vodafone E1 Environment")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Neha Oza");

        extent.loadConfig(new File("src/test/resources/extent-config.xml"));
        System.out.println("ENv host --------> " + System.getProperty("env-host"));

    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        // Passing the value from the mvn command as - mvn test -Denv-host=https://onlyfullstack.blogspot.com
        // webDriver.get(System.getProperty("env-host") + "/2020/03/best-demo-website-to-practice-selenium.html");
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("window.scrollBy(0,2200)");
        System.out.println("inside beforeMethod");
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = ScreenshotCapture.capture(webDriver);
            extentTestObject.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            extentTestObject.log(LogStatus.FAIL, "Test Case Failed is ", result.getThrowable());
            extentTestObject.log(LogStatus.FAIL, "Snapshot below: " + extentTestObject.addScreenCapture(screenShotPath));

        }else if(result.getStatus() == ITestResult.SKIP){
            extentTestObject.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(extentTestObject);
        webDriver.close();
    }

    @AfterClass
    public void endReport(){
        // writing everything to document
        //flush() - to write or update test information to your report.
        extent.flush();
        //Call close() at the very end of your session to clear all resources.
        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
        //Once this method is called, calling any Extent method will throw an error.
        //close() - To close all the operation
        extent.close();
    }

    @Test
    public void main1() throws InterruptedException {

        //extent.startTest("TestCaseName", "Description")
        //TestCaseName – Name of the test
        //Description – Description of the test
        //Starting test
        extentTestObject = extent.startTest("Checking the label", " label checking on sign up page.");

        Assert.assertEquals(true, false);
        WebElement nameTextField = webDriver.findElement(By.id("name-text-field-id"));
        nameTextField.sendKeys("neha ");

        webDriver.findElement(By.className("email-text-field-class")).sendKeys("j.nnehajoshi@gmail.com");
        webDriver.findElement(By.name("Zip")).sendKeys("12345");

        webDriver.findElement(By.tagName("textarea")).sendKeys("saurabhj");
        webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[4]/td[2]/input")).sendKeys("31/07/1991");
        Assert.assertEquals(false, true);
        //To generate the log when the test case is passed
        extentTestObject.log(LogStatus.PASS, "Test Case Passed is passTest");

    }

    @Test
    private void validateEmail() {
        extentTestObject = extent.startTest("Checking the label 2");
        System.out.println("inside validateEmail");

        String lable2 = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(lable2, "Email1");
        extentTestObject.log(LogStatus.PASS, "Test Case Passed is passTest");
    }

    @Test
    public void validateLables() {
        System.out.println("inside validateLables");
        extentTestObject = extent.startTest("Checking the label 3");
        String lable = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(lable, "Name");
        extentTestObject.log(LogStatus.PASS, "Test Case Passed is passTest");
    }
}
