package Tests.Assignments.Assignment05;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class T06_OldStyleSelectMenu {
    WebDriver driver;
    Select select;
    String url = "https://demoqa.com/select-menu";


    @BeforeEach
    void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open https://demoqa.com/select-menu
        driver.get(url);

        // Select Old Style Select Menu using element id
        WebElement oldStyleSelect = driver.findElement(By.id("oldSelectMenu"));
        select = new Select(oldStyleSelect);
    }

    @Test
    void printAndSelect() throws InterruptedException {

        // Print all dropdown options
        List<WebElement> options = select.getOptions();
        System.out.println("All dropdown options in 'Old Style Select Menu' are:");

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());

        }

        // Select 'Purple' using index
        select.selectByIndex(4);
        System.out.println("Selected '" + select.getFirstSelectedOption().getText() + "' by index");
        Thread.sleep(500);

        // Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        System.out.println("Selected '" + select.getFirstSelectedOption().getText() + "' by visible text");
        Thread.sleep(500);

        // Select an option using value
        select.selectByValue("1");
        System.out.println("Selected '" + select.getFirstSelectedOption().getText() + "' by value");
        Thread.sleep(500);
    }

    @AfterEach
    void tearDown() {
        // Close browser
        driver.quit();
    }
}