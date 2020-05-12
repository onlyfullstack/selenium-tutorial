package com.onlyfullstack.selenium.webDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class NavigationCommands {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://onlyfullstack.blogspot.com");

        System.out.println("Navigated to = "+webDriver.getCurrentUrl());
        Thread.sleep(1000);

        webDriver.navigate().back();
        System.out.println("Back to = "+webDriver.getCurrentUrl());
        Thread.sleep(1000);

        webDriver.navigate().forward();
        System.out.println("Forwarded to = "+webDriver.getCurrentUrl());
        Thread.sleep(1000);

        webDriver.navigate().refresh();

        webDriver.close();

        //webDriver.quit();
    }
}
