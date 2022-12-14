package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.tagName("input"));
        fullnameInput.sendKeys("mike smith with tagname");

        WebElement emailInput = driver.findElement(By.tagName("input"));
        emailInput.sendKeys("mike@smith.com");

        //lazy way to click button
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        //close browser
        driver.quit();





    }
}
