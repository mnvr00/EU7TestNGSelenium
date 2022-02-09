package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    @Test
    public void Test2() throws InterruptedException {

        //WebDriver driver = Driver.get(); i can delete this part
        //driver.get("https://www.google.com"); i can combine this two

        Driver.get().get("https://www.google.com");

        Driver.closeDriver();
    }
    @Test
    public void Test3(){

        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com");


        Driver.get().get("https://www.amazon.com");

    }
}
