package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("open browser");
    }

    @Test
    public void test1() {

        System.out.println("first assertion");
        Assert.assertEquals("title", "tiTle");
        //if assertion is fail , it stops execution that line, doesnt run rest of the code. that is why if there is problem title part onlyfirst assertaion  part appear

        System.out.println("second assertion");
        Assert.assertEquals("url", "url");
    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2" , "verify test2");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyt";
        String actualType = "Cybertek";

        Assert.assertTrue(actualType.startsWith(expectedTitle),"verify title starts with Cyb");

        }
   @Test
   public void test4(){
        //verify email contains @ sign
       String email = "mike@smith.com";

       Assert.assertTrue(email.contains("@"),"verify email contains @");
   }

   @Test
   public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
   }
   @Test
   public void test6(){
        Assert.assertNotEquals("one","two");
   }

    @AfterMethod
    public void tearDown(){
        System.out.println("close browser");
    }

}
