package com.onlyfullstack.selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class AlertOperations {

    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html#alert-tutorial");

        webDriver.findElement(By.linkText("Simple Alert")).click();
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text = " + alertText);
        alert.accept();

        webDriver.findElement(By.xpath("//*[@id=\"alert-tutorial\"]/tbody/tr[3]/td/a")).click();
        Alert confirmAlert = webDriver.switchTo().alert();
        String confirmAlertText = confirmAlert.getText();
        System.out.println("Confirm Alert text = " + confirmAlertText);
        confirmAlert.dismiss();

        webDriver.findElement(By.linkText("Prompt Alert")).click();
        Alert promptAlert = webDriver.switchTo().alert();
        String promptAlertText = promptAlert.getText();
        System.out.println("Prompt Alert text = " + promptAlertText);
        promptAlert.accept();
    }

}
