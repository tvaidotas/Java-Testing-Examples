package com.qa;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tadas\\IdeaProjects\\testingexamples\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        driver.manage().window().maximize();
        driver.get("http://google.com");
        try {
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
