package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
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
    public void contactDetailsTest(){
        extentLogger = report.createTest("Contact Info Verification");

        // login as a sales manager

        //to use locators of Loginpage
        LoginPage loginPage = new LoginPage();

        //from conf.properties i will give username and passw.
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username" +username);
        extentLogger.info("password" +password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);//loginpagede login methodunu cagir


        //navigate to customers ->contacts

        //basepage i direk cagiramiyorum cunki o abstract class. that is why i call dashboardd because it is extended to basepage
        //DashboardPage dashboardPage = new DashboardPage(); instead of long form if you will use once you can use like this
        //dashboardPage.navigateToModule();

        extentLogger.info("Navigate to --> Customers > Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts"); //bu lazy form


        //click on email
        ContactPage contactPage = new ContactPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        contactPage.waitUntilLoaderScreenDisappear();
        contactPage.getContactEmail("mbrackstone9@example.com").click();

        //verifications
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();
        extentLogger.info("Verify full name is "+ expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName, "verify full name");

        extentLogger.info("verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");

        extentLogger.info("verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");


        extentLogger.pass("PASSED");


    }

}
