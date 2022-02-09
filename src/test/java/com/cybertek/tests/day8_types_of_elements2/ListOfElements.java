package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        //it doesnt matter test case is fail or not, anyway it closes the browser

    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //you need to find common locator for all

        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        //verify button size
        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        //iter +enter to get each loop with shortcut
        for (WebElement button : buttons) {
            System.out.println(button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed()); //it is not verification, you need to put assert
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed ");

        }
        //click second button //here is java 2 is equalt to 1 in java due to index
        buttons.get(1).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //regular findElement method will throw NHE if locator doesnt exist
        //driver.findElement(By.tagName("buttonasdjsj"));

        //passing locator which doesnt exist , it will not throw NoSuchElement
        //ALT+enter or option+enter then one more enter for shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("buttondgdfgf"));
        System.out.println("buttons.size() = " + buttons.size());

//you need to verify size everytime even though it ca n not find the locaot it doesnt give errorr


    }


}
