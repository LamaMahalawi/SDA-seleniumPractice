package Tests.Assignments.Assignment03;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C02SecondAssingment {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    void navigationAndInputTest() {
        // TODO: Navigate to test pages
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // TODO: Click on "Locators - Find By Playground Test Page"
        WebElement locatorsLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        locatorsLink.click();
        System.out.println("Current URL after clicking Locators: " + driver.getCurrentUrl());

        // TODO: Navigate back
        driver.navigate().back();
        System.out.println("URL after going back: " + driver.getCurrentUrl());

        // TODO: Click on "WebDriver Example Page"
        WebElement webDriverExampleLink = driver.findElement(By.linkText("WebDriver Example Page"));
        webDriverExampleLink.click();
        System.out.println("Current URL after clicking WebDriver Example Page: " + driver.getCurrentUrl());

        // TODO: Enter value 20 in number input
        WebElement numberInput = driver.findElement(By.id("numentry"));
        numberInput.sendKeys("20");

        // TODO:Click submit button
        WebElement submitButton = driver.findElement(By.id("submit-to-server"));
        submitButton.click();

        // TODO: Verify 'two, zero' message appears
        WebElement message = driver.findElement(By.id("message"));
        String actualText = message.getText();
        System.out.println("Displayed message: " + actualText);
        Assertions.assertEquals("two, zero", actualText);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}