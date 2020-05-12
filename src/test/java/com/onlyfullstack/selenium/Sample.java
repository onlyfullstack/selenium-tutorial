package com.onlyfullstack.selenium;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

public class Sample {

    WebDriver webDriver;

    ExtentReports extent;
    ExtentTest logger;


    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeClass
    public void setup() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        System.out.println("insise before class");
        //ExtentReports(String filePath,Boolean replaceExisting)
        //filepath - path of the file, in .htm or .html format - path where your report needs to generate.
        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
        extent = new ExtentReports ("test-output/STMExtentReport.html", true);
        //extent.addSystemInfo("Environment","Environment Name")
        extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Rajkumar SM");
        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File("src/test/resources/extent-config.xml"));
    }

    @AfterClass
    public void after() {
        System.out.println("insise after class");
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        /*webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("window.scrollBy(0,2200)");
        System.out.println("inside beforeMethod");*/
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(logger);
        webDriver.close();
    }
    @AfterTest
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
        logger = extent.startTest("Checking the label");

        Assert.assertEquals(true, false);
       /* WebElement nameTextField = webDriver.findElement(By.id("name-text-field-id"));
        nameTextField.sendKeys("neha ");

        webDriver.findElement(By.className("email-text-field-class")).sendKeys("j.nnehajoshi@gmail.com");
        webDriver.findElement(By.name("Zip")).sendKeys("12345");

        webDriver.findElement(By.tagName("textarea")).sendKeys("saurabhj");
        webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[4]/td[2]/input")).sendKeys("31/07/1991");
*/
        //To generate the log when the test case is passed
        logger.log(LogStatus.PASS, "Test Case Passed is passTest");

    }

//    @Test
    private void validateEmail() {
        System.out.println("inside validateEmail");

        String lable2 = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(lable2, "Email1");
    }

//    @Test
    public void validateLables() {
        System.out.println("inside validateLables");
        String lable = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(lable, "Name");
    }
}

