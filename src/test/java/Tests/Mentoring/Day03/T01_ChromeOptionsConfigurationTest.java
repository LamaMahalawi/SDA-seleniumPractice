package Tests.Mentoring.Day03;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class T01_ChromeOptionsConfigurationTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("--disable-infobars");


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void chromeOptionsTest() {
        driver.get("https://www.example.com");

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assertions.assertTrue(title.contains("Example"), "Title should contain 'Example'");
    }
}
