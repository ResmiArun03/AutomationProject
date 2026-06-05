package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest {

    @Test
    public void registerUser() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");

        // Click Signup/Login
        driver.findElement(
            By.xpath("//a[contains(text(),'Signup / Login')]"))
            .click();

        Thread.sleep(3000);

        // Enter Name
        driver.findElement(By.name("name"))
            .sendKeys("Resmi");

        // Enter Email (must be new every time)
        driver.findElement(
            By.xpath("//input[@data-qa='signup-email']"))
            .sendKeys("resmi12345@gmail.com");

        // Click Signup
        driver.findElement(
            By.xpath("//button[@data-qa='signup-button']"))
            .click();

        Thread.sleep(3000);

        // Validation
        String text = driver.findElement(
            By.xpath("//b[contains(text(),'Enter Account Information')]"))
            .getText();

        Assert.assertTrue(text.contains("ENTER ACCOUNT INFORMATION"));
        driver.findElement(By.id("id_gender2")).click();

        driver.findElement(By.id("password"))
              .sendKeys("Resmi@123");

        driver.findElement(By.id("days"))
              .sendKeys("10");

        driver.findElement(By.id("months"))
              .sendKeys("May");

        driver.findElement(By.id("years"))
              .sendKeys("1998");
        driver.findElement(By.id("first_name"))
        .sendKeys("Resmi");

  driver.findElement(By.id("last_name"))
        .sendKeys("K");

  driver.findElement(By.id("address1"))
        .sendKeys("Kochi");

  driver.findElement(By.id("country"))
        .sendKeys("India");

  driver.findElement(By.id("state"))
        .sendKeys("Kerala");

  driver.findElement(By.id("city"))
        .sendKeys("Kochi");

  driver.findElement(By.id("zipcode"))
        .sendKeys("682001");

  driver.findElement(By.id("mobile_number"))
        .sendKeys("9876543210");
  driver.findElement(
		    By.xpath("//button[@data-qa='create-account']"))
		    .click();
  Thread.sleep(3000);
  String accountCreated = driver.findElement(
		    By.xpath("//b[contains(text(),'Account Created!')]"))
		    .getText();

		System.out.println(accountCreated);

		Assert.assertEquals(accountCreated, "ACCOUNT CREATED!");
		driver.findElement(
			    By.xpath("//a[@data-qa='continue-button']"))
			    .click();
		Assert.assertTrue(
			    driver.findElement(
			        By.xpath("//a[contains(text(),'Logged in as')]"))
			        .isDisplayed());
		
		
        driver.quit();
    }
}