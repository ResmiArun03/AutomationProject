package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrandFilterTest {

    @Test
    public void verifyBrandFilter() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/products");

        Thread.sleep(3000);

        // Click BabyHug Brand
        driver.findElement(
        	    By.xpath("//a[@href='/brand_products/Babyhug']"))
        	    .click();

        Thread.sleep(3000);

        // Verify Brand page opened
        Assert.assertTrue(
                driver.getCurrentUrl().contains("brand_products"));

        // Verify products are displayed
        Assert.assertTrue(
                driver.findElements(
                        By.xpath("//div[@class='product-image-wrapper']"))
                        .size() > 0);

        System.out.println("Brand Filter Test Passed");

        driver.quit();
    }
}