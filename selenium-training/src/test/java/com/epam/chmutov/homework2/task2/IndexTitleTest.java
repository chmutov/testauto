package com.epam.chmutov.homework2.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndexTitleTest {

    private static final String TEST_URL = "https://www.epam.com";

    @BeforeClass
    public void initClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test(groups = {"smoke"})
    public void testIndexTitle() {
        WebDriver driver = getWebDriver();
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    private static WebDriver getWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL);
        return driver;
    }

    @Test(groups = {"smoke"})
    public void testIndexLogo() {
        WebDriver driver = getWebDriver();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@title]")).isDisplayed());
        driver.close();
    }
}
