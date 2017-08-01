package com.carle.cubetest;

import org.openqa.selenium.WebDriver;

public class GeneralActions {
 
    public void openAppUrl (WebDriver driver) {
        // Navigate to app
        String target = "http://www.ivan.carle.dk/cube/cube.html";
        driver.get(target);   
    }
    
}
