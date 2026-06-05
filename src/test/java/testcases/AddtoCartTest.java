package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddtoCartTest {

    @Test
    public void addToCart() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/products");

        Thread.sleep(3000);

        // Hover over first product
        WebElement product = driver.findElement(
                By.xpath("(//div[@class='product-image-wrapper'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        Thread.sleep(1000);

        // Click Add to Cart
        driver.findElement(
                By.xpath("(//a[contains(@class,'add-to-cart')])[1]"))
                .click();

        Thread.sleep(2000);

        // Verify popup displayed
        Assert.assertTrue(
                driver.findElement(By.id("cartModal"))
                .isDisplayed());

        // Click View Cart
        driver.findElement(
                By.xpath("//u[text()='View Cart']"))
                .click();

        Thread.sleep(2000);

        // Verify cart page opened
        Assert.assertTrue(
                driver.getCurrentUrl().contains("view_cart"));

        // Verify product exists in cart
        Assert.assertTrue(
                driver.findElement(By.id("cart_info_table"))
                .isDisplayed());

        System.out.println("Product added to cart successfully");

        driver.quit();
    }
}