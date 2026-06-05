package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CategoryFilterTest {

    @Test
    public void verifySareeCategory() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        Thread.sleep(3000);

        // Click Women category
        WebElement women = driver.findElement(
                By.xpath("//a[@href='#Women']"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", women);

        Thread.sleep(2000);

        // Click Saree using exact href
        WebElement saree = driver.findElement(
                By.xpath("//a[@href='/category_products/7']"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", saree);

        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}