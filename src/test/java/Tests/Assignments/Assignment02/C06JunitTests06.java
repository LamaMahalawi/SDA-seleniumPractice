package Tests.Assignments.Assignment02;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06JunitTests06 {
    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        // Launch Chrome browser and maximize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
    void test01_navigat() throws InterruptedException {
        System.out.println("Navigating to Google");
        driver.get("https://www.google.com");
        System.out.println("Verifying title contains 'Google'");
        Assertions.assertTrue(driver.getTitle().contains("Google"));
        Thread.sleep(1000);

        //

        System.out.println("Navigating to YouTube");
        driver.get("https://www.youtube.com");
        System.out.println("Verifying title contains 'YouTube'");
        Assertions.assertTrue(driver.getTitle().contains("YouTube"));
        Thread.sleep(1000);
        //

        System.out.println("Navigating to LinkedIn");
        driver.get("https://www.linkedin.com");
        System.out.println("Verifying title contains 'LinkedIn'");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
        Thread.sleep(1000);
    }

    @Test
    void test02() throws InterruptedException {
        System.out.println("Navigating to Google → YouTube → LinkedIn");
        driver.get("https://www.google.com");
        driver.get("https://www.youtube.com");
        driver.get("https://www.linkedin.com");

        System.out.println("Navigating back twice");
        driver.navigate().back(); // YouTube
        driver.navigate().back(); // Google
        System.out.println("Verifying current URL is Google");
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());
        Thread.sleep(1000);

        System.out.println("Navigating forward twice");
        driver.navigate().forward(); // YouTube
        driver.navigate().forward(); // LinkedIn
        System.out.println("Verifying current URL is LinkedIn");
        Assertions.assertEquals("https://www.linkedin.com/", driver.getCurrentUrl());
        Thread.sleep(1000);

}
        @AfterEach
        void tearDown() {
            // Close browser
            driver.quit();
        }
    }