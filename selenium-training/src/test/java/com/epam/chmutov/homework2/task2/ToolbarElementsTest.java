package com.epam.chmutov.homework2.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolbarElementsTest {

    private static final String TEST_URL = "https://www.epam.com";

    @BeforeClass
    public void initClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test(groups = {"regression"})
    public void testSolutions() {
        WebDriver driver = getWebDriver();
        WebElement element = driver.findElement(By.xpath("//a[@href='/solutions']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "SOLUTIONS");
        driver.close();
    }

    @Test(groups = {"regression"})
    public void testIndustries() {
        WebDriver driver = getWebDriver();
        WebElement element = driver.findElement(By.xpath("//a[@href='/industries']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "INDUSTRIES");
        driver.close();
    }

    @Test(groups = {"regression"})
    public void testAbout() {
        WebDriver driver = getWebDriver();
        WebElement element = driver.findElement(By.xpath("//a[@href='/about']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "ABOUT");
        driver.close();
    }

    @Test(groups = {"regression"})
    public void testIdeas() {
        WebDriver driver = getWebDriver();
        WebElement element = driver.findElement(By.xpath("//a[@href='/ideas']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "IDEAS");
        driver.close();
    }

    @Test(groups = {"regression"})
    public void testCareers() {
        WebDriver driver = getWebDriver();
        WebElement element = driver.findElement(By.xpath("//a[@href='/careers']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "CAREERS");
        driver.close();
    }

    private static WebDriver getWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        return driver;
    }
}
