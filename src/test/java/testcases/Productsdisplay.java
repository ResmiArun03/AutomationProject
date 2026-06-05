package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.testng.Assert;

public class Productsdisplay {



@Test
public void verifyProductsDisplayed() {

    WebDriver driver = new ChromeDriver();
    driver.get("https://automationexercise.com/products");

    int count = driver.findElements(
            By.xpath("//div[@class='product-image-wrapper']"))
            .size();

    Assert.assertTrue(count > 0);

    driver.quit();
}
}