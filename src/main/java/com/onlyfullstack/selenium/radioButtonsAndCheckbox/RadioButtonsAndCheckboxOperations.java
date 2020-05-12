package com.onlyfullstack.selenium.radioButtonsAndCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class RadioButtonsAndCheckboxOperations {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,2200)");

//        selectRadioButtonsAndCheckbox(webDriver);
        checkIfRadioButtonsAndCheckboxSelected(webDriver);
    }

    private static void checkIfRadioButtonsAndCheckboxSelected(WebDriver webDriver) {
        WebElement radioButton = webDriver.findElement(By.id("male"));
        WebElement singingCheckBox = webDriver.findElement(By.id("hobby1"));
        WebElement playingCheckBox = webDriver.findElement(By.id("hobby2"));

        System.out.println("Is Male Radio button Selected? = " + radioButton.isSelected());
        System.out.println("Is Singing CheckBox Selected? = " + singingCheckBox.isSelected());
        System.out.println("Is Playing CheckBox Selected? = " + playingCheckBox.isSelected());

        radioButton.click();
        singingCheckBox.click();
        playingCheckBox.click();
        System.out.println("Is Male Radio Button selected after click? = " + radioButton.isSelected());
        System.out.println("Is Singing CheckBox selected after click? = " + singingCheckBox.isSelected());
        System.out.println("Is Playing CheckBox selected after click? = " + playingCheckBox.isSelected());
    }

    private static void selectRadioButtonsAndCheckbox(WebDriver webDriver) throws InterruptedException {
        WebElement radioButton = webDriver.findElement(By.id("male"));
        radioButton.click();

        Thread.sleep(1000);

        WebElement singingCheckBox = webDriver.findElement(By.id("hobby1"));
        singingCheckBox.click();

        WebElement playingCheckBox = webDriver.findElement(By.id("hobby2"));
        playingCheckBox.click();

        Thread.sleep(2000);
    }
}
