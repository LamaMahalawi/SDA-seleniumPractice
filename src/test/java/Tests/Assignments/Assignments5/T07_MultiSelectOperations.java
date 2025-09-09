package Tests.Assignments.Assignments5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class T07_MultiSelectOperations {
    WebDriver driver;
    Select multiSelect;

    @BeforeEach
    void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

        // Select Standard Multi-Select using element id
        multiSelect = new Select(driver.findElement(By.id("cars")));
    }

    @Test
    void multiSelect() throws InterruptedException {

        // Verify element is multi-select
        System.out.println("Is multi-select ? " + multiSelect.isMultiple());
        Assertions.assertTrue(multiSelect.isMultiple());

        // Select 'Opel' using index then deselect using index
        multiSelect.selectByIndex(2); // Opel
        System.out.println("Selected " + multiSelect.getFirstSelectedOption().getText() + " by index");
        Thread.sleep(1500);
        multiSelect.deselectByIndex(2);
        System.out.println("Deselected");
        Thread.sleep(1500);

        // Select 'Saab' using value then deselect using value
        multiSelect.selectByValue("saab");
        System.out.println("Selected  " + multiSelect.getFirstSelectedOption().getText() + "by value");
        Thread.sleep(1500);
        multiSelect.deselectByValue("saab");
        Thread.sleep(1500);
        System.out.println("Deselected");

        // Deselect all options
        multiSelect.selectByValue("volvo");
        multiSelect.selectByValue("audi");
        multiSelect.deselectAll();
        Thread.sleep(1500);
        System.out.println("All options deselected");
    }

    @AfterEach
    void tearDown() {
        // Close browser
        driver.quit();
    }
}
