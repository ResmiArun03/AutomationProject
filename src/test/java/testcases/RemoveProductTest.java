package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductTest {

    @Test
    public void removeProductFromCart() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/products");

        Thread.sleep(3000);

        // Add first product to cart
        driver.findElement(
                By.xpath("(//a[contains(@class,'add-to-cart')])[1]"))
                .click();

        Thread.sleep(2000);

        // View Cart
        driver.findElement(
                By.xpath("//u[text()='View Cart']"))
                .click();

        Thread.sleep(3000);

        // Click Delete button
        driver.findElement(
                By.xpath("//a[contains(@class,'cart_quantity_delete')]"))
                .click();

        Thread.sleep(3000);

        // Verify cart is empty
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[contains(text(),'Cart is empty')]"))
                        .isDisplayed());

        System.out.println("Product removed successfully");

        driver.quit();
    }
}