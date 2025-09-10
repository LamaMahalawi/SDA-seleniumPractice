package Tests.Mentoring.Day03;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class T03_RadioButtonSelection {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void radioButtonTest() {
        // Locate labels instead of inputs
        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveLabel = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noRadio = driver.findElement(By.xpath("//input[@id='noRadio']"));

        // Test Yes
        testRadioButton(yesLabel, driver.findElement(By.id("yesRadio")), "Yes");

        // Test Impressive
        testRadioButton(impressiveLabel, driver.findElement(By.id("impressiveRadio")), "Impressive");

        // Test No
        testRadioButton(null, noRadio, "No");
    }

    private void testRadioButton(WebElement label, WebElement radioButton, String name) {
        if (radioButton.isEnabled()) {
            System.out.println(name + " option is enabled ");

            // Click label (to avoid intercept exception)
            if (label != null) label.click();

            Assertions.assertTrue(radioButton.isSelected(), name + " should be selected!");
            System.out.println(name + " has been successfully selected ");
        } else {
            System.out.println(name + " option is disabled ");
        }
    }}