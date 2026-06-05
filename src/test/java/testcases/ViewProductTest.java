package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewProductTest {

    @Test
    public void verifyViewProduct() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://automationexercise.com");

        // Click Products
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Thread.sleep(2000);

        // Locate View Product button
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        WebElement viewProduct = driver.findElement(
                By.xpath("(//a[contains(text(),'View Product')])[1]"));

        js.executeScript("arguments[0].scrollIntoView(true);", viewProduct);

        Thread.sleep(1000);

        // Find again before clicking
        viewProduct = driver.findElement(
                By.xpath("(//a[contains(text(),'View Product')])[1]"));

        js.executeScript("arguments[0].click();", viewProduct);
        Thread.sleep(2000);

        // Verify Product Details page
        Assert.assertTrue(
                driver.getCurrentUrl().contains("product_details"));

        // Verify Product Name
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//div[@class='product-information']/h2"))
                        .isDisplayed());

        // Verify Category
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//p[contains(text(),'Category')]"))
                        .isDisplayed());

        // Verify Availability
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//b[contains(text(),'Availability')]"))
                        .isDisplayed());

        // Verify Brand
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//b[contains(text(),'Brand')]"))
                        .isDisplayed());

        System.out.println("View Product Details Test Passed");

        driver.quit();
    }
}