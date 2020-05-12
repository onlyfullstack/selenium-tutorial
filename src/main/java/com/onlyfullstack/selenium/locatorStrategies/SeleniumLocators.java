package com.onlyfullstack.selenium.locatorStrategies;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.List;

public class SeleniumLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,2200)");

//        locateByCssSelectorClass(webDriver);
locateById(webDriver);
        Thread.sleep(3000);
        webDriver.close();
    }

    private static void locateById(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.id("name-text-field-id"));
        nameTextField.sendKeys("Only FullStack ");
    }

    private static void locateByClassName(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.className("email-text-field-class"));
        nameTextField.sendKeys("onlyfullstack@gmail.com");
    }

    private static void locateByName(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.name("Zip"));
        nameTextField.sendKeys("411033 ");
    }

    private static void locateByAbsoluteXPath(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[8]/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/form/table/tbody/tr[8]/td[2]/textarea"));
        nameTextField.sendKeys("411033 ");
    }

    private static void locateByRelativeXPath(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[8]/td[2]/textarea"));
        nameTextField.sendKeys("411033 ");
    }

    private static void locateByTagName(WebDriver webDriver) throws InterruptedException {
        List<WebElement> links = webDriver.findElements(By.tagName("a"));

        for(WebElement webElement : links) {
            if("Terms and Conditions".equals(webElement.getText())) {
                webElement.click();
                Thread.sleep(1000);
                webDriver.switchTo().alert().accept();
            }
        }
    }

    private static void locateByCssSelectorId(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.cssSelector("input#name-text-field-id"));
        nameTextField.sendKeys("Only FullStack with css selector id");
    }

    private static void locateByCssSelectorClass(WebDriver webDriver) {

        WebElement nameTextField = webDriver.findElement(By.cssSelector("input.email-text-field-class"));
        nameTextField.sendKeys("onlyfullstack@gmail.com ");

        webDriver.findElement(By.linkText("OnlyFullStack Terms and Conditions"));


    }
}
