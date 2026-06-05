package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.testng.Assert;

public class Productstest {

    @Test
    public void verifyProductsPage() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("products"));
        boolean displayed =
        		driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[1]"))
        		.isDisplayed();

        		Assert.assertTrue(displayed);
        		
        		driver.quit();
    }
}