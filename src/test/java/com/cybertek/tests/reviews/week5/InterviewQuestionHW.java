package com.cybertek.tests.reviews.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InterviewQuestionHW {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.ionicpartners.com/");
    }
    @AfterMethod
    public void TearDown(){
        driver.close();

    }

    @Test
    public void Hw(){
       /* HW: v.Test application www.IonicPartners.com:
        vi. Test 1: Go to <Blog> page and scroll it down
        vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page

        */








    }
}
