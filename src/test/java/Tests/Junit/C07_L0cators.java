package Tests.Junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_L0cators {

    static WebDriver driver;
    @BeforeAll
    public static void setUp() {

        // TODO: Initialize WebDriver
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO: Navigate to LinkedIn
        driver.get("https://www.linkedin.com/login");
    }


    @Test
    public void testLoginElements() {
// TODO: Locate email field using By.id
        By emailFieldById = By.id("username");
// TODO: Locate password field using By.name
        By passWordFieldByName = By.name("session_password");
// TODO: Locate sign-in button using By.xpath
        By signInButtonByXpath = By.xpath("//button[@type='submit']");

// TODO: Enter test credentials
        WebElement emailField = driver.findElement(emailFieldById);
        emailField.sendKeys();///////

        WebElement passField = driver.findElement(passWordFieldByName);
        passField.sendKeys();///////////

        WebElement signInButton = driver.findElement(signInButtonByXpath);


// TODO: Verify elements are displayed
        Assertions.assertTrue(emailField.isDisplayed());
        Assertions.assertTrue(passField.isDisplayed());
        Assertions.assertTrue(signInButton.isDisplayed());

        signInButton.click();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();

    }
}