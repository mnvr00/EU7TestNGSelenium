package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginpage = new LoginPage();

        loginpage.usernameInput.sendKeys("user1");
        loginpage.passwordInput.sendKeys("somepassword");
        loginpage.loginBtn.click();

       // driver.findElement(By.id("prependedInput")).sendKeys(username);
       // driver.findElement(By.id("prependedInput2")).sendKeys(password);
       // driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.perfleet.com/user/login");
    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.perfleet.com/user/login");

    }

}

