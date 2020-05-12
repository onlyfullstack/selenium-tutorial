package com.onlyfullstack.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Sample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("window.scrollBy(0,2200)");


        WebElement nameTextField = webDriver.findElement(By.id("name-text-field-id"));
        nameTextField.sendKeys("neha ");

        webDriver.findElement(By.className("email-text-field-class")).sendKeys("j.nnehajoshi@gmail.com");
        webDriver.findElement(By.name("Zip")).sendKeys("12345");

        webDriver.findElement(By.tagName("textarea")).sendKeys("saurabhj");
        webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[4]/td[2]/input")).sendKeys("31/07/1991");

        String lable2 =webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]")).getText();
        if(!lable2.equals("Email1")){
            System.out.println("email not working");
        }

        validateLables(webDriver);

        Thread.sleep(3000);

        webDriver.close();
        System.exit(0);
    }

    public static void validateLables(WebDriver webDriver) {


        String lable = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]")).getText();
        if (!lable.equals("Name")) {

            System.out.println("name not working");
        }
    }

}

