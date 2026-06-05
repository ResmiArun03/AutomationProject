package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest {

    @Test
    public void logoutUser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        driver.findElement(
            By.xpath("//a[contains(text(),'Signup / Login')]"))
            .click();

        Thread.sleep(3000);

        driver.findElement(
            By.xpath("//input[@data-qa='login-email']"))
            .sendKeys("Resmi@sample.com");

        driver.findElement(
            By.xpath("//input[@data-qa='login-password']"))
            .sendKeys("Resmi@1");

        driver.findElement(
            By.xpath("//button[@data-qa='login-button']"))
            .click();

        Thread.sleep(3000);

        // Verify login
        Assert.assertTrue(
            driver.findElement(
                By.xpath("//a[contains(text(),'Logged in as')]"))
                .isDisplayed());
        System.out.println(driver.getCurrentUrl());
        // Click Logout
        driver.findElement(
        	    By.xpath("//a[contains(@href,'/logout')]"))
        	    .click();

        Thread.sleep(5000);

        // Verify Login page displayed
        Assert.assertTrue(
        	    driver.findElement(
        	        By.xpath("//a[contains(text(),'Logged in as')]"))
        	        .isDisplayed());

        	Thread.sleep(5000);

        	driver.findElement(
        	    By.xpath("//a[contains(@href,'/logout')]"))
        	    .click();
    }
}