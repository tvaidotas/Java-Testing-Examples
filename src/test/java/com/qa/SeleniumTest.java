package com.qa;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class SeleniumTest
{

    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tadas\\IdeaProjects\\testingexamples\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void exampleSeleniumTest()
    {
        try {
            driver.manage().window().maximize();
            driver.get("http://google.com");
            Thread.sleep(500);
            driver.findElement(By.name("q")).sendKeys("funny cat pics");
            Thread.sleep(500);
            driver.findElement(By.name("btnK")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
