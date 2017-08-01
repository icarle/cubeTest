package com.carle.cubetest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtility {
    
    public static void takeScreenshot(WebDriver driver, String identifier) {
        
            Date dNow = new Date();
            SimpleDateFormat it = new SimpleDateFormat("MMddhhmmssSSS");
            String delta = it.format(dNow);
            File scrFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("test_screenshot_" + delta + "_" + identifier + ".png"));
            } catch (IOException ex) {
            }
        
    }
    
        public String getProperty(String e) {
        String result = null;
        Properties prop = new Properties();
        try {
            InputStream in = getClass().getResourceAsStream("/config.properties");
            prop.load(in);
            result = prop.getProperty(e);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
