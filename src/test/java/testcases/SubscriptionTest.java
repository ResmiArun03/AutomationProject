package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTest {

    @Test
    public void verifySubscription() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        // Scroll to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(2000);

        // Verify Subscription heading
        Assert.assertTrue(
                driver.findElement(By.xpath("//h2[text()='Subscription']"))
                        .isDisplayed());

        // Enter email
        driver.findElement(By.id("susbscribe_email"))
                .sendKeys("test123@gmail.com");

        // Click subscribe button
        driver.findElement(By.id("subscribe"))
                .click();

        Thread.sleep(3000);

        // Verify success message
        String successMsg = driver.findElement(
                By.id("success-subscribe"))
                .getText();

        Assert.assertTrue(
                successMsg.contains("You have been successfully subscribed!"));

        System.out.println("Subscription Successful");

        driver.quit();
    }
}