package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) {

       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/multiple_buttons");

      //click dont click button
        WebElement dontclickButton = driver.findElement(By.id("disappearing_button"));
        dontclickButton.click();






    }
}
