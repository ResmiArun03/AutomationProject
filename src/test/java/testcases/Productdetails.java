package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Productdetails {

    @Test
    public void verifyProductDetails() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        // Click Products
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Thread.sleep(2000);

        // Click first View Product using JavaScript
        WebElement viewProduct =
                driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewProduct);

        // Verify URL
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));

        // Verify Product Name
        Assert.assertTrue(
                driver.findElement(By.xpath("//div[@class='product-information']/h2"))
                        .isDisplayed());

        // Verify Category
        Assert.assertTrue(
                driver.findElement(By.xpath("//p[contains(text(),'Category')]"))
                        .isDisplayed());

        // Verify Price
        Assert.assertTrue(
                driver.findElement(By.xpath("//span/span"))
                        .isDisplayed());

        // Verify Availability
        Assert.assertTrue(
                driver.findElement(By.xpath("//b[contains(text(),'Availability')]"))
                        .isDisplayed());

        driver.quit();
    }
}