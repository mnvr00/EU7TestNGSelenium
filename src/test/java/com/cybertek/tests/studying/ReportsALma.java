package com.cybertek.tests.studying;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportsALma extends TestBase {
    @Test
    public void test(){
        extentLogger = report.createTest("my negative test");
        LoginPage lp =new LoginPage();

        extentLogger.info("enter username: useruserr");
        lp.usernameInput.sendKeys("useruserr");

        extentLogger.info("enter password: jkdfnkkdk");
        lp.passwordInput.sendKeys("jkdfnkkdk");

        extentLogger.info("Click login button");
        lp.loginBtn.click();

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.perfleet.com/user/login");

        extentLogger.pass("negatif test is pass");



    }
}
