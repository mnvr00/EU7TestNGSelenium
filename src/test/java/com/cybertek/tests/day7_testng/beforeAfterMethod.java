package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class beforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("====before class====");
        System.out.println("executed one time before one class");
    }
    @Test
    public void test1() {
        System.out.println("first test case");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("second test case");

    }
    @Test
    public void test3(){
        System.out.println("second test case");

    }

     @BeforeMethod
     public void setUp(){
         System.out.println("before method");
         System.out.println("webDriver, opening browser");

     }

     @AfterMethod
    public void tearDown(){
         System.out.println("after method");
         System.out.println("closing browser,quit");

     }

     @AfterClass
    public void tearDownClass(){
         System.out.println("====after class====");
         System.out.println("some reporting code is here");

     }
}
