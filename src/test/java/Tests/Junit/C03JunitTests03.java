package Tests.Junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03JunitTests03 {
    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        // Launch Chrome browser and maximize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }


    @Test
    void test01_navigationHistory() {
        // Go to Wikipedia
        driver.get("https://www.wikipedia.org");
        String wikiTitle = driver.getTitle();
        System.out.println("Wikipedia title is : " + wikiTitle );

        // Go to Google
        driver.get("https://www.google.com");
        String googleTitle = driver.getTitle();
        System.out.println("Google title is : " + googleTitle );

        // Back to Wikipedia and assert
        System.out.println("Going back to Wikipedia");
        driver.navigate().back();

        System.out.println("Current title after back :" + driver.getTitle());
        Assertions.assertEquals(wikiTitle, driver.getTitle());

        // Forward to Google and assert
        System.out.println("Going back to Google");
        driver.navigate().forward();

        System.out.println("Current title after forward : " + driver.getTitle());
        Assertions.assertEquals(googleTitle, driver.getTitle());
    }

    @Test
    void test02_refreshGoogle() {

        // Go to Google
        driver.get("https://www.google.com");

        // Refresh
        System.out.println("Refreshing Google");
        driver.navigate().refresh();

        // Assert title still contains "Google"
        System.out.println("Current title after Refreshing : " + driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Google"));
    }
    @AfterEach
    void tearDown() {
        // Close the browser
        driver.quit();
    }
    }