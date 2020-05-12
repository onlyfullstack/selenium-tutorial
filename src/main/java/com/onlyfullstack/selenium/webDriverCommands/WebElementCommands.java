package com.onlyfullstack.selenium.webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebElementCommands {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        WebElement emailTextField = webDriver.findElement(By.className("email-text-field-class"));
        emailTextField.sendKeys("onlyfullstack@gmail.com");
        Thread.sleep(1000);
        emailTextField.clear();

        WebElement termsAndCondition = webDriver.findElement(By.xpath("//*[@id=\"post-body-39246966950473039\"]/div/form/table/tbody/tr[1]/td[1]"));
        System.out.println("Name text (getText()) = " + termsAndCondition.getText());

        emailTextField = webDriver.findElement(By.className("email-text-field-class"));
        System.out.println("Tag Name (getTagName()) = " + emailTextField.getTagName());

        WebElement radioButton = webDriver.findElement(By.id("male"));
        System.out.println("Is Displayed? (isDisplayed()) = " + radioButton.isDisplayed());
        System.out.println("Is Enabled? (isEnabled()) = " + radioButton.isEnabled());
        System.out.println("Is Selected? (isSelected()) = " + radioButton.isSelected());

        radioButton.click();
        System.out.println("Is Selected after radio button click? (isSelected()) = " + radioButton.isSelected());

        webDriver.close();
    }
}
