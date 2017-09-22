package com.epam.chmutov.homework2.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClickAboutTest {
    private static final String TEST_URL = "https://www.epam.com";

    @BeforeClass
    public void initClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test(groups = {"smoke", "regression"})
    public void testCompany() {
        WebDriver driver = getWebDriver();
        driver.findElement(By.xpath("//a[@href='/about']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=' Company']")).isDisplayed());
        driver.close();
    }

    @Test(groups = {"smoke", "regression"})
    public void testNewsRoom() {
        WebDriver driver = getWebDriver();
        driver.findElement(By.xpath("//a[@href='/about']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=' Newsroom']")).isDisplayed());
        driver.close();
    }

    @Test(groups = {"smoke", "regression"})
    public void testInvestors() {
        WebDriver driver = getWebDriver();
        driver.findElement(By.xpath("//a[@href='/about']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=' Investors']")).isDisplayed());
        driver.close();
    }

    private static WebDriver getWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        return driver;
    }
}
