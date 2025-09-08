package Tests.Mentoring.Junit.Day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C02JunitTests02 {
    // Go to google homepage
// Do the following tasks by creating 3 different test methods.
// Print "Tests are starting to run" before each test() method
// Print "Tests have finished running" after each test() method
// Test if the title is the same when the page window is maximize and minimize
// Test if the title does not contain "Video" when the page window is fullscreen
// Test if the URL contains "google"

    static WebDriver driver;

    String url = "https://www.google.com";


    @BeforeEach
    public void setUp() throws InterruptedException {
        System.out.println("New Tests are starting to run");
        driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);
    }


    @Test
    void testTitleMaximizeAndMinimize() throws InterruptedException {
        driver.manage().window().maximize();
        String titleMax = driver.getTitle();

        driver.manage().window().minimize();
        String titleMin = driver.getTitle();

        Assertions.assertEquals(titleMax, titleMin, "Title are not equals");
        Thread.sleep(1000);
    }

    @Test
    void testTitleDoesNotContainVideoInFullscreen() {
        driver.manage().window().fullscreen();
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"), "Title should not contain 'Video'");
    }

    @Test
    void testUrlContainsGoogle() {
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("google"), "URL should contain 'google'");

    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        driver.quit();
        System.out.println("Tests have finished running");
        Thread.sleep(1000);
    }
}