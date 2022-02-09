package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {
        //it is regular way
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();

        //because of method i do like this
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);
    }


}
