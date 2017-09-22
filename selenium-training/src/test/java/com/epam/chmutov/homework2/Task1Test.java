package com.epam.chmutov.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task1Test {
    @DataProvider
    public Object[][] xpathPatternAndExpectedTextProvider() {
        return new Object[][]{
                {"//span[text()=\"To include good practices\"]", "To include good practices\nand ideas from successful\nEPAM projec"},
                {"//span[text()=\"To be flexible and\"]", "To be flexible and\ncustomizable"},
                {"//span[text()=\"To be multiplatform \"]", "To be multiplatform"},
                {"//span[text()=\"Already have good base\"]", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};
    }

    @Test(dataProvider = "xpathPatternAndExpectedTextProvider")
    public void testMainPageSpanTexts(String xpathPattern, String expectedText) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.findElement(By.xpath(xpathPattern)).getText(), expectedText);
        driver.close();
    }

    @Test(dataProvider = "xpathPatternAndExpectedTextProvider", threadPoolSize = 2, invocationCount = 2)
    public void testMainPageSpanTextsInParallel(String xpathPattern, String expectedText) {
        testMainPageSpanTexts(xpathPattern, expectedText);
    }

}
