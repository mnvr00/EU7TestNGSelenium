package com.cybertek.tests.day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions -->class that contains all the user interactions
        //how to create actions object==> passing driver as a constructor
        Actions actions = new Actions(driver); //how to move your mouse

        //perform()==> perform the action,complete the action
        //moveToElement ==> move you mouse to webelement (hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform(); //perform is used in order to complete

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed());
    }

        @Test
        public void dragAndDrop() throws InterruptedException {

            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
            driver.manage().window().maximize();

            Actions actions = new Actions(driver);

            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droptarget"));


            //driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

            //if you have accept and close message use this
            driver.findElement(By.xpath("//*[.='Accept and Close']")).click();

            Thread.sleep(2000);
            actions.dragAndDrop(source, target).perform();

        }

            /* if doesn open the browser, try this one
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();

             */
            @Test
            public void dragAndDropChaining() throws InterruptedException {
                driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
                driver.manage().window().maximize();

                Actions actions = new Actions(driver);

                List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
                List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
                Thread.sleep(1000);
                if(acceptAndClose.size()>0){
                    acceptAndClose.get(0).click();
                }else if(acceptCookies.size()>0){
                    acceptCookies.get(0).click();
                }

                WebElement source = driver.findElement(By.id("draggable"));
                WebElement target = driver.findElement(By.id("droptarget"));

                Thread.sleep(2000);
                actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


            }



}





