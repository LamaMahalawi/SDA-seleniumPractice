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

            // Step 1: Go to https://claruswaysda.github.io/dragAndDrop.html
            driver.get("https://claruswaysda.github.io/dragAndDrop.html");
            System.out.println("Opened drag and drop page successfully");


            // Locate piece elements
            WebElement piece1 = driver.findElement(By.xpath("//*[@id=\"piece1\"]")); // One
            WebElement piece2 = driver.findElement(By.xpath("//*[@id=\"piece2\"]")); // Two
            WebElement piece3 = driver.findElement(By.xpath("//*[@id=\"piece3\"]")); // Three

            // Locate slot
            WebElement slot1 = driver.findElement(By.xpath("//*[@id=\"slot1\"]"));
            WebElement slot2 = driver.findElement(By.xpath("//*[@id=\"slot2\"]"));
            WebElement slot3 = driver.findElement(By.xpath("//*[@id=\"slot3\"]"));


            // Step 2: Drag the items in their right places
            Actions actions = new Actions(driver);

            actions.dragAndDrop(piece1, slot1).perform();
            actions.dragAndDrop(piece2, slot2).perform();
            actions.dragAndDrop(piece3, slot3).perform();
            System.out.println("Dragged all 3 boxes successfully");



            // Wait for success message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"celebrate\"]")));

            // Step 3: Assert the success message
            String actualMsg = successMsg.getText();
            System.out.println("Assertion successful -> " + actualMsg);
        }
    }