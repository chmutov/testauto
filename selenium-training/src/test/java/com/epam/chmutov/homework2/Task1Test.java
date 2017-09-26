package com.epam.chmutov.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Task1Test {
    @DataProvider
    private Object[][] expectedTextProvider() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM projec"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"},
        };
    }

    @DataProvider(parallel = true)
    private Object[][] parallelExpectedTextProvider() {
        return expectedTextProvider();
    }

    @Test(dataProvider = "expectedTextProvider")
    public void testMainPageSpanTexts(int elementIndex, String expectedText) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        final WebDriver driver = new ChromeDriver();
        try {
            driver.navigate().to("https://jdi-framework.github.io/tests");
            List<WebElement> benefitTxtElements = driver.findElements(By.cssSelector(".benefit-txt"));
            if(benefitTxtElements.size() <= elementIndex) {
                Assert.fail(".benefit-txt element #" + elementIndex + " not found");
            }
            Assert.assertEquals(benefitTxtElements.get(elementIndex).getText(), expectedText);
        } finally {
            driver.close();
        }
    }

    @Test(dataProvider = "parallelExpectedTextProvider")
    public void testMainPageSpanTextsInParallel(int elementIndex, String expectedText) {
        testMainPageSpanTexts(elementIndex, expectedText);
    }

}
