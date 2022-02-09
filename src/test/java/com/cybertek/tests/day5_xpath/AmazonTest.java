package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /**
     * TASK
     * go to amazon.com
     * search for selenium
     * click search button
     * verify 1-48 of 304 results for "Selenium"
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox")); //burda beyaz search boxi actm
        searchBox.sendKeys("selenium"); //boxa selenium yazdm

        driver.findElement(By.xpath("//input[@value='Go']")).click(); //ara tusuna bastm ve seleniumu aradi

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]")); //resulti gosterdm
        String resultText = result.getText(); //resulti cektm
        System.out.println("resultText = " + resultText);

        String expectedResult = "1-48 of 202 results for";

        if(expectedResult.equals(resultText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("resultText = " + resultText);
        }


        driver.quit();


    }

}
