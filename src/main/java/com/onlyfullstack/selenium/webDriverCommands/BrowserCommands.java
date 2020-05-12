package com.onlyfullstack.selenium.webDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BrowserCommands {
    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com");

        String pageTitle = webDriver.getTitle();
        System.out.println("Page Title - " + pageTitle);

        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Current Url - " + currentUrl);

        String pageSource = webDriver.getPageSource();
        System.out.println("Page Source - " + pageSource);

        webDriver.close();

        //webDriver.quit();
    }
}
