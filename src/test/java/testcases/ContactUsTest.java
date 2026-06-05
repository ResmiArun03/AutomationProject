package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest {

    @Test
    public void verifyContactUsForm() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        // Click Contact Us
        driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();

        // Enter details
        driver.findElement(By.name("name")).sendKeys("Resmi");
        driver.findElement(By.name("email")).sendKeys("resmi@test.com");
        driver.findElement(By.name("subject")).sendKeys("Testing Contact Form");
        driver.findElement(By.id("message")).sendKeys("This is a Selenium TestNG automation test.");

        // Upload file
        driver.findElement(By.name("upload_file"))
              .sendKeys("E:\\Testing\\Resmi Resume.pdf");

        // Click Submit
        driver.findElement(By.name("submit")).click();

        // Handle Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Verify Success Message
        boolean success = driver.findElement(
                By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]"))
                .isDisplayed();

        Assert.assertTrue(success);

        driver.quit();
    }
}