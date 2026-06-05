package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProducts {

    @Test
    public void searchProduct() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        driver.findElement(By.id("search_product"))
              .sendKeys("Blue Top");

        driver.findElement(By.id("submit_search"))
              .click();

        Assert.assertTrue(
                driver.findElement(By.xpath("//p[text()='Blue Top']"))
                      .isDisplayed());

        driver.quit();
    }
}