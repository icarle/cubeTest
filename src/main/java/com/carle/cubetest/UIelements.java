/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carle.cubetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ICA
 */
public class UIelements {
    
    public WebDriver driver;

    UIelements(WebDriver driver) {
        this.driver = driver;
    }
    
    // Main nav menu (must be opened)
//    <a id="newCube" title="Create a new cube">new cube</a>
//    <a id="deleteCube" title="Delete the currently selected cube">delete cube</a>
//    <a id="deleteAllCubes">delete all data &amp; cubes</a>
    
    
    
    public WebElement selectCube() {
        return this.driver.findElement(By.id("selectCube"));
    }
     
    // card input text field 
    public WebElement input_cardInput() {
        return this.driver.findElement(By.id("cardInput"));
    }
    
    // button that adds card to database
    public WebElement button_addCard() {
        return this.driver.findElement(By.id("addCard"));
    }
    
    // Main table --
    public WebElement table_cubeTable() {
        return this.driver.findElement(By.id("cubeTable"));
    }
    
    // Need to return specific row from table - should be its own class
    
    
    
}
