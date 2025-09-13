package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class T04_DrawingPractice extends TestBase {

    @Test
    void testDrawTriangle() throws InterruptedException {

        // Step 1: Go to https://claruswaysda.github.io/Draw.html
        driver.get("https://claruswaysda.github.io/Draw.html");


        // Step 2: Draw a triangle
        WebElement canvas = driver.findElement(By.id("myCanvas"));


        Actions actions = new Actions(driver);

        // First line
        actions.moveToElement(canvas, 150, 20).clickAndHold().moveByOffset(-50, 80).release().perform();

        // Second line
        actions.moveToElement(canvas, 100, 100).clickAndHold().moveByOffset(100, 0).release().perform();


        // Third line
        actions.moveToElement(canvas, 200, 100).clickAndHold().moveByOffset(-50, -80).release().perform();
        Thread.sleep(500);
        System.out.println("Triangle drawn successfully");

        // Step 4: Click Reset button
        driver.findElement(By.id("resetButton")).click(); //<button id="resetButton">Reset</button>
        Thread.sleep(500);
        System.out.println("Canvas reset successfully");
    }
}
