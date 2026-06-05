package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logintest {

    @Test
    public void loginUser() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Signup / Login')]")))
                    .click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@data-qa='login-email']")))
                    .sendKeys("Resmi@sample.com");

            driver.findElement(
                    By.xpath("//input[@data-qa='login-password']"))
                    .sendKeys("Resmi@1");

            driver.findElement(
                    By.xpath("//button[@data-qa='login-button']"))
                    .click();

            // Verify Logged in as user
            WebElement loggedIn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'Logged in as')]")));

            Assert.assertTrue(loggedIn.isDisplayed());

            System.out.println(loggedIn.getText());

        } finally {
            driver.quit();
        }
    }
}