package Tests.Mentoring.Junit.Day03;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class C06_ChromeOptionsConfigurationTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        // إعداد الخيارات
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");   // تكبير النافذة مع التشغيل
        options.addArguments("--disable-extensions"); // تعطيل الإضافات
        options.addArguments("--incognito");         // وضع التصفح الخفي
        options.addArguments("--disable-infobars");  // إخفاء شريط "Chrome is being controlled..."

        // تشغيل المتصفح مع الخيارات
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
