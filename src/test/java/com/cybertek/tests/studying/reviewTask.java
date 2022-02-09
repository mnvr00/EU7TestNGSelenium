package com.cybertek.tests.studying;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class reviewTask extends TestBase {
    /**
     * open the chrome
     * go to qa.perfleet
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void task(){

        extentLogger = report.createTest("confirmation of contact details");

        LoginPage lp =new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username" +username);
        extentLogger.info("password" +password);
        extentLogger.info("Login as a Sales Manager");
        lp.login(username,password);

        extentLogger.info(" navigate to customers ->contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactPage cp = new ContactPage();
        extentLogger.info("clicking email");
        cp.waitUntilLoaderScreenDisappear();
        cp.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage cip = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = cip.fullName.getText();
        extentLogger.info("Verify full name is "+ expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName, "verify full name");

        String expectedemail = "mbrackstone9@example.com";
        String actualEmail = cip.email.getText();
        extentLogger.info("verify email" + expectedemail);
        Assert.assertEquals(actualEmail,expectedemail);

        extentLogger.info("verifying phone");
        Assert.assertEquals(cip.phone.getText(),"+18982323434");

        extentLogger.pass("my task is pass");





    }

}
