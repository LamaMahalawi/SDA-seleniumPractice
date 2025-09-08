package Tests.Junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_GoogleSearchTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() throws InterruptedException {
// TODO: Initialize static WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// TODO: Navigate to Google
        driver.get("https://www.google.com");
        Thread.sleep(1000);
    }

    @Test
    public void searchMovies() throws InterruptedException {
        String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};
        for (String movie : movies) {
// TODO: Find search box
        WebElement searchBox = driver.findElement(By.name("q"));
// TODO: Clear and enter movie name
        searchBox.clear();
        searchBox.sendKeys(movie);
// TODO: Submit search
        searchBox.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
        Thread.sleep(5000);
// TODO: Get and print result count
        try {
              WebElement resultStats = driver.findElement(By.id("result-stats"));
              System.out.println(movie + " - " + resultStats.getText());
        } catch (Exception e) {
              System.out.println(movie + " - Results not found");
        }

            // Navigate back to Google home page for next iteration
            driver.navigate().back();
            
        }
    }

// TODO: Clear search box for next iteration
    @AfterAll
    public static void tearDown() {
        driver.quit();

    }}

