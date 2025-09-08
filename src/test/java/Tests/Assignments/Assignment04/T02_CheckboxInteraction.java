package Tests.Assignments.Assignment04;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02_CheckboxInteraction {
     /*Task: Go to "https://the-internet.herokuapp.com/checkboxes"
    Write a method that:
    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */

    static WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);
    }

    @Test
    void checkboxesTest() throws InterruptedException {
        // Locate both checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));


        // Ensure checkbox1 is selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        // Ensure checkbox2 is selected
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Thread.sleep(2000);

        // Verify both are selected
        Assertions.assertTrue(checkbox1.isSelected(), "Checkbox 1 should be selected!");
        Assertions.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected!");

        // Print status to console
        System.out.println("Checkbox 1 selected: " + checkbox1.isSelected());
        System.out.println("Checkbox 2 selected: " + checkbox2.isSelected());
    }

        @AfterEach
        void tearDown() {
            driver.quit();
        }
    }


