package com.onlyfullstack.selenium.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotCapture {

    public static String capture(WebDriver driver) {
        Date oDate = new Date();
        SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
        String sDate = oSDF.format(oDate);
        String encodedBase64 = null;
        FileInputStream fileInputStream = null;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            // If you want to store the image please uncomment the below code
            /* String destination ="target/extent-test-report/error-screenshots/"+"Screenshot_" + sDate + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination); */

            fileInputStream =new FileInputStream(source);
            byte[] bytes =new byte[(int)source.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

        }catch (IOException e){
            e.printStackTrace();
        }
        return "data:image/png;base64,"+encodedBase64;
    }

}
