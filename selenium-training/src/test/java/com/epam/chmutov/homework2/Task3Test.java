package com.epam.chmutov.homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task3Test {

    private WebDriver driver;

    @BeforeSuite
    public void initSuite() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeClass
    public void initClass() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void initTest() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterSuite
    public void destroySuite() {
        if (driver.toString().contains("null")) { driver.quit(); }
    }

    @AfterMethod
    public void destroyMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void destroyTest() {
        driver.close();
    }

    @Test
    public void navigateToHomePage() {
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }
}
