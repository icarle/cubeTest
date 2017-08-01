/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carle.cubetest;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ICA
 */
@RunWith(JUnit4.class)
public class CardAdd {

    private static WebDriver driver;
    TestUtility utility = new TestUtility();
      

    // Run the following before this entire class' tests are executed
    @BeforeClass
    public static void setUpClass() throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver\\x32\\geckodriver.exe"); //TODO set dynamic property
        driver = new FirefoxDriver(); // Initiate a firefox browser
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1366, 768));
    }

    @AfterClass
    public static void tearDownClass() {
        driver.close();
    }

    @Test
    public void addCard() throws IOException {
        boolean expResult = true;
        boolean result = false;
        
        // Initiate elements class
        UIelements elements = new UIelements(this.driver);
        GeneralActions actions = new GeneralActions();
        
        //open app
        actions.openAppUrl(driver);
        
       
        // Get the input element ad insert card name
        WebElement e = elements.input_cardInput();
        e.clear();
        String cardname = this.utility.getProperty("card");
        e.sendKeys(new CharSequence[]{cardname}); // dynamic value from test properties
        
        // We might need to sleep a bit to wait for the card lookup in deckbrew
        try {Thread.sleep(800);} catch (InterruptedException ex) {}
        
        // Click the add card button to add the card to the database
        e = elements.button_addCard();
        e.click();
        
        try {Thread.sleep(800);} catch (InterruptedException ex) {}
        this.utility.takeScreenshot(driver, "_ui_after_adding_card");
        
        // Test that it is in the table ui
        boolean existsInUi = false;
        
        
        // test that the entry is in the database
        boolean existsInDb = false;


        // If the card exists both in database and in ui the test is successful
        if (existsInDb && existsInUi) {
            result = true;
        }
        
        //assert result
        Assert.assertEquals(expResult, result);
    }
}