package Tests.Junit_Selenium_MorningClass.Day04_Suleyman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

// Time-based synchronization - Static wait
// Static wait represents waiting for a fixed amount of time
// The execution continues only after the specified time has passed
// In Selenium with Java, we use the Thread.sleep() method to implement static waits
// It is not recommended for dynamic web applications, as it may cause unnecessary delays or failures
//    Go to https://webdriveruniversity.com/Popup-Alerts/index.html
//    Click on Ajax Loader
//    Click on 'Click Me'
//    Assert text "Well Done For Waiting....!!!"

public class C12_HardWaitAndImplicitWait {
    WebDriver driver;
    String url = "";

    @Test
    void hardWaitTest() throws InterruptedException {

    }

    @Test
    void implicitWaitTest() throws InterruptedException {
/* Implicit wait assigns a default waiting time for all elements on the page.
    However, once the element is found, it stops waiting immediately.
    This applies to all elements on the page and waits until the specified time for an element to be located.
    In other words, it waits for the given duration to avoid NoSuchElementException.
    Implicit wait is global, meaning the same wait time is applied to all web elements.*/

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Sets a global wait for all elements (no need to set again for each one)

 //Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        //    Click on Ajax Loader
        //Thread.sleep(6000);
        //    Click on 'Click Me'
        //    Assert text "Well Done For Waiting....!!!"

    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
