package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void SwitchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("title before new window:" + driver.getTitle());
        driver.findElement(By.linkText("Click here")).click();
        System.out.println("title after new window:" + driver.getTitle());

        // System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle(); //there is uniqu code

        Set<String> windowHandles = driver.getWindowHandles(); //rest of the windows
//if there are 2 windiws
        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after switch new window:"+driver.getTitle());

    }

    @Test
    public void moreThan2Window(){

        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before Switch:"+driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

//you will switch one by one
        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);

            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;  //after verifiying and swithin true one we can stop to loop
            }

        }

        System.out.println("After Switch: "+driver.getTitle());

    }







}
