package com.cybertek.tests.studying;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebtablesEx {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void gettable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void headers(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void tablesize(){
        //number of columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(rows.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());

    }

    @Test
    public void getrow(){ //first method
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i < allRowsWithoutHeader.size(); i++) {
            WebElement allRows = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+ "-" + allRows.getText());
        }
    }



    @Test
    public void getrow2(){ //second method aynisi 1ile
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement element  : allRowsWithoutHeader) {
            System.out.println(element.getText());
        }
    }


    @Test
    public void getAllCellInOneRow() {
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
    }





}
