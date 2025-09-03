package Tests.Junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C04JunitTests04 {
    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        // Launch Chrome browser and maximize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    void test01_seleniumPageSource() {
        System.out.println("Navigating to Selenium website");
        driver.get("https://www.selenium.dev");

        String pageSource = driver.getPageSource();
        System.out.println("Checking if page source contains 'WebDriver'");
        Assertions.assertTrue(pageSource.contains("WebDriver"));
        System.out.println("'WebDriver' found in page source");
    }
    @Test
    void test02_pythonPageSource() {
        System.out.println("Navigating to Python website");
        driver.get("https://www.python.org");

        String pageSource = driver.getPageSource();
        System.out.println("Checking if page source contains 'Python'");
        Assertions.assertTrue(pageSource.contains("Python"));
        System.out.println("'Python' found in page source");
    }

    @AfterEach
    void tearDown() {
        // Close the browser
        driver.quit();
    }
}