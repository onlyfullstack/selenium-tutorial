package com.onlyfullstack.selenium.dropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownOperations {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,2200)");

        //selectDropDownValue(webDriver);
        getAllDropDownValues(webDriver);
        webDriver.close();
    }

    private static void getAllDropDownValues(WebDriver webDriver) throws InterruptedException {
        WebElement countryDropDownElement = webDriver.findElement(By.name("Country"));
        Select countryDropDown = new Select(countryDropDownElement);

        List<WebElement> dropDownList = countryDropDown.getOptions();

        System.out.println("DropDown values - ");
        for(WebElement dropDown : dropDownList) {
            System.out.println(dropDown.getText());
        }
    }

    private static void selectDropDownValue(WebDriver webDriver) throws InterruptedException {
        WebElement countryDropDownElement = webDriver.findElement(By.name("Country"));
        Select countryDropDown = new Select(countryDropDownElement);

        countryDropDown.selectByVisibleText("India");
        Thread.sleep(1000);

        countryDropDown.selectByValue("2");
        Thread.sleep(1000);

        countryDropDown.selectByIndex(3);
        Thread.sleep(1000);
    }
}
