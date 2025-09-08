package Tests.Assignments.Assignment04;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class T05_DynamicListManagement {
       /*Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain */

    static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    void dynamicListManagementTest() throws InterruptedException {
        Faker faker = new Faker();

        //Generate 5 random tasks and add them to the todo list
        for (int i = 0; i < 5; i++) {
            String taskName = faker.lorem().word();
            System.out.println("Generated Task: " + taskName);
            driver.findElement(By.xpath("//input")).sendKeys(taskName, Keys.ENTER);
            Thread.sleep(500);
        }

        //Mark every other task as completed (strikethrough)
        List<WebElement> tasks = driver.findElements(By.xpath("//ul//li"));
        for (int i = 0; i < tasks.size(); i += 2) {
            tasks.get(i).click();
            Thread.sleep(500);
        }

        //Delete all completed tasks
        List<WebElement> completedTasks = driver.findElements(By.xpath("//li[@class='completed']"));
        for (WebElement task : completedTasks) {
            task.findElement(By.xpath(".//i[contains(@class,'fa-trash')]")).click();
            Thread.sleep(500);
        }

        //Verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.xpath("//li"));
        for (WebElement task : remainingTasks) {
            Assertions.assertFalse(task.getAttribute("class").contains("completed"));
            Thread.sleep(500);
        }

        System.out.println("Remaining Incomplete Tasks: " + remainingTasks.size());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}