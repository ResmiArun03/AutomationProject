package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrandProductTest {

    @Test
    public void verifyBrandProducts() throws Exception {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Click Products menu
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='/products']"))).click();

            // Verify Brands section is displayed
            WebElement brandsSection = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@class='brands_products']")));

            Assert.assertTrue(brandsSection.isDisplayed(),
                    "Brands section is not displayed");

            // Locate Biba brand
            WebElement biba = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//a[contains(@href,'/brand_products/Biba')]")));

            // Scroll to Biba
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", biba);

            Thread.sleep(1000);

            // Click using JavaScript (avoids ad overlay issue)
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", biba);

            // Verify URL
            wait.until(ExpectedConditions.urlContains("brand_products"));

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("/brand_products/Biba"),
                    "Biba brand page was not opened");

            // Verify products displayed
            int productCount = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[@class='product-image-wrapper']")))
                    .size();

            Assert.assertTrue(productCount > 0,
                    "No products displayed for Biba brand");

            System.out.println("Brand Product Test Passed");

        } finally {
            driver.quit();
        }
    }
}