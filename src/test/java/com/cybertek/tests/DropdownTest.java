package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.bouncycastle.jcajce.provider.symmetric.Twofish;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class DropdownTest {

    WebDriver driver;  //declare our reference for the object

    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome"); //create the object
        driver.manage().window().maximize();

        // implicitly wait, this is going to be applayed to while test casese and element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test(){
        WebElement userInputbox= driver.findElement(By.id("ctl00_MainContent_username"));
        userInputbox.sendKeys("Tester");
        WebElement passwordButton = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordButton.sendKeys("test"+ Keys.ENTER);

        WebElement orderLink=driver.findElement(By.linkText("Order"));
        orderLink.click();

        String expectedSelectedoption="MyMoney";
        WebElement productDropDownElement=driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select productDropDown=new Select(productDropDownElement);
        String actualSelectedOption = productDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOption,expectedSelectedoption,"first option selected is not as expected");




    }

}
