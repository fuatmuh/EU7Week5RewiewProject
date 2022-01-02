package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChercherTest {

    WebDriver driver;  //declare our reference for the object
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome"); //create the object
        driver.manage().window().maximize();

        // implicitly wait, this is going to be applayed to while test casese and element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void alertPresentTest(){


    }


}
