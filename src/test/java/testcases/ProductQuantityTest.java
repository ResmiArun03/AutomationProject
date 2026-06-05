package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductQuantityTest {

    @Test
    public void verifyProductQuantity() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com");

        Thread.sleep(2000);

        // Click first View Product
        driver.findElement(
                By.xpath("(//a[contains(text(),'View Product')])[1]"))
                .click();

        Thread.sleep(2000);

        // Clear default quantity
        driver.findElement(By.id("quantity")).clear();

        // Enter quantity 4
        driver.findElement(By.id("quantity")).sendKeys("4");

        // Add to cart
        driver.findElement(
                By.xpath("//button[contains(text(),'Add to cart')]"))
                .click();

        Thread.sleep(2000);

        // View Cart
        driver.findElement(
                By.xpath("//u[text()='View Cart']"))
                .click();

        Thread.sleep(2000);

        // Verify quantity
        String qty = driver.findElement(
                By.xpath("//button[@class='disabled']"))
                .getText();

        Assert.assertEquals(qty, "4");

        System.out.println("Quantity verified successfully");

        driver.quit();
    }
}