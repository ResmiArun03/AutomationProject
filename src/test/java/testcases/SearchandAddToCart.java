package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchandAddToCart{

    @Test
    public void searchAndAddToCart() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/products");

        Thread.sleep(2000);

        // Search product
        driver.findElement(By.id("search_product"))
              .sendKeys("Winter Top");

        driver.findElement(By.id("submit_search"))
              .click();

        Thread.sleep(2000);

        // Verify searched product displayed
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[contains(text(),'Winter Top')]"))
                        .isDisplayed());

        // Add product to cart
        driver.findElement(
                By.xpath("(//a[contains(@class,'add-to-cart')])[1]"))
                .click();

        Thread.sleep(2000);

        // View Cart
        driver.findElement(
                By.xpath("//u[text()='View Cart']"))
                .click();

        Thread.sleep(2000);

        // Verify product in cart
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[contains(text(),'Winter Top')]"))
                        .isDisplayed());

        System.out.println("Search Product and Add to Cart Passed");

        driver.quit();
    }
}