package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage{
    //since we are extending BasePage we do not need explicit constructor for this class

//    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
//    public WebElement email;
    //based on this xpah we can locate all others emails bu using this way

    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        //String xpath= "(//td[@data-column-label='Email'])[1]";
        return Driver.get().findElement(By.xpath(xpath));
    }
}

