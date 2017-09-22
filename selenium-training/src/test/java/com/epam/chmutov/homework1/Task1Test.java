package com.epam.chmutov.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Task1Test {

    private WebDriver driver;

    @Test
    public void checkTitleAndLoginAndUpdateContacts() {

        final SoftAssert assertCollector = new SoftAssert();

        // Open test site by URL and Assert Browser title
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
        assertCollector.assertEquals(driver.getTitle(), "Index Page");

        // Perform login
        driver.findElement(By.xpath("//a[@href='#' and @class='dropdown-toggle' and @data-toggle='dropdown' and text()]")).click();
        driver.findElement(By.xpath("//input[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//form/button")).click();

        // Assert User name in the left-top side of screen
        assertCollector.assertEquals(driver.findElement(By.xpath("html/body/div/header/div/nav/ul[2]/li/a/div/span")).getText(), "PITER CHAILOVSKII");

        // Open Contact form and Assert Browser title
        driver.findElement(By.xpath("//a[@href='page1.htm' and text()='Contact form']")).click();
        assertCollector.assertEquals(driver.getTitle(), "Contact Form");

        // Input my first and last name in text fields and click submit button
        driver.findElement(By.xpath("//input[@id='Name']")).sendKeys("Alexey");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Chmutov");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Assert data changed and the button clicked
        WebElement logElement = driver.findElement(By.xpath("//div[@class='info-panel-body info-panel-body-log']"));
        String logElementText = logElement.getText();
        assertCollector.assertTrue(logElementText.contains("Name: value changed to Alexey"), "Name should change to Alexey");
        assertCollector.assertTrue(logElementText.contains("LastName: value changed to Chmutov"), "LastName should change to Chmutov");
        assertCollector.assertTrue(logElementText.contains("submit:button clicked"), "Submit button should be clicked");

        assertCollector.assertAll();
    }

    @BeforeTest
    private void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    private void closeWebDriver() {
        driver.close();
        driver = null;
    }
}
