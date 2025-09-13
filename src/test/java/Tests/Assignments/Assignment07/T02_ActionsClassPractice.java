package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T02_ActionsClassPractice extends TestBase {

    @Test
    void testActions() {

        Actions actions = new Actions(driver);
        By submit = By.xpath("//*[@id=\"submitButton\"]");

        // Go to https://claruswaysda.github.io/submit-button.html
        driver.get("https://claruswaysda.github.io/submit-button.html");

        // Click on submit
        driver.findElement(submit).click();


        // Verify link contains 'actionsClickDrag'
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("actionsClickDrag"));
       // Assertions.assertTrue(driver.getCurrentUrl().contains("actionsClickDrag"));
       // System.out.println("URL verification passed ");



        // Drag 'Drag me' to 'Drop here'
        actions.dragAndDrop(driver.findElement(By.id("draggable")),
        driver.findElement(By.id("droppable"))).perform();
        System.out.println("Drag and Drop performed ");

        // Right-click on 'Right-click me'
        actions.contextClick(driver.findElement(By.id("rightClick"))).perform();
        System.out.println("Right Click performed");

        // Double-click on 'Double-click me'
        actions.doubleClick(driver.findElement(By.id("doubleClick"))).perform();
        System.out.println("Double Click performed");

        // Hover on 'Hover over me'
        actions.moveToElement(driver.findElement(By.id("hoverOver"))).perform();
        System.out.println("Hover performed");

        // Verify all actions' success messages
        Assertions.assertTrue(driver.findElement(By.id("dragResult")).getText().contains("Dropped!"));
        Assertions.assertTrue(driver.findElement(By.id("rightClickResult")).getText().contains("Right-click successful"));
        Assertions.assertTrue(driver.findElement(By.id("doubleClickResult")).getText().contains("Double-click successful"));
        Assertions.assertTrue(driver.findElement(By.id("hoverResult")).getText().contains("Hovered!"));

        System.out.println("All actions verified successfully");
    }
}