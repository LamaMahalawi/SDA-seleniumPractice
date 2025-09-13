package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class T03_DragAndDropPractice extends TestBase {


    @Test
    void testDragAndDrop() {

            // Step 1: Open the page
            driver.get("https://claruswaysda.github.io/dragAndDrop.html");
            System.out.println("Opened drag and drop page");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            // Step 2: Locate draggable elements
            WebElement box1 = driver.findElement(By.id("draggable1")); // One
            WebElement box2 = driver.findElement(By.id("draggable2")); // Two
            WebElement box3 = driver.findElement(By.id("draggable3")); // Three

            // Step 3: Locate drop targets
            WebElement target1 = driver.findElement(By.id("droppable1"));
            WebElement target2 = driver.findElement(By.id("droppable2"));
            WebElement target3 = driver.findElement(By.id("droppable3"));

            // Step 4: Perform drag and drop
            actions.dragAndDrop(box1, target1).perform();
            actions.dragAndDrop(box2, target2).perform();
            actions.dragAndDrop(box3, target3).perform();
            System.out.println("Dragged all 3 boxes successfully");

            // Step 5: Wait for success message
            WebElement successMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("msg"))
            );

            // Step 6: Assert the success message
            String actualMsg = successMsg.getText();
            Assertions.assertEquals("Congratulations!", actualMsg);
            System.out.println("Assertion successful -> " + actualMsg);
        }
    }