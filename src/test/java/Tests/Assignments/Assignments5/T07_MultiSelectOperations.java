package Tests.Assignments.Assignments5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class T07_MultiSelectOperations {

    WebDriver driver;
    Select multiSelect;
    String url = "https://demoqa.com/select-menu";


    @BeforeEach
    void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open https://demoqa.com/select-menu
        driver.get(url);

        // Select Standard Multi-Select using element id
        multiSelect = new Select(driver.findElement(By.id("cars")));
    }

    @Test
    void multiSelect() throws InterruptedException {

        // Verify element is multi-select
        System.out.println("Is 'Standard multi select' ? " + multiSelect.isMultiple());
        Assertions.assertTrue(multiSelect.isMultiple());

        // Select 'Opel' using index then deselect using index
        multiSelect.selectByIndex(2);
        System.out.println("1-Selected '" + multiSelect.getFirstSelectedOption().getText() + "' by index");
        Thread.sleep(500);
        multiSelect.deselectByIndex(2);
        System.out.println("2-Deselected");
        Thread.sleep(500);

        // Select 'Saab' using value then deselect using value
        multiSelect.selectByValue("saab");
        System.out.println("1-Selected '" + multiSelect.getFirstSelectedOption().getText() + "' by value");
        Thread.sleep(500);
        multiSelect.deselectByValue("saab");
        Thread.sleep(500);
        System.out.println("2-Deselected");

        // Deselect all options
        multiSelect.selectByValue("volvo");
        Thread.sleep(500);
        multiSelect.selectByValue("audi");
        multiSelect.deselectAll();
        Thread.sleep(500);
        System.out.println("All options deselected successfully");
    }

    @AfterEach
    void tearDown() {
        // Close browser
        driver.quit();
    }
}
