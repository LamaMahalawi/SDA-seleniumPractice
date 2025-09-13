package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;


public class T02_ActionsClassPractice extends TestBase {

    @Test
    public void testActionsPractice() throws InterruptedException {

        // Step 1: Go to https://claruswaysda.github.io/submit-button.html
        driver.get("https://claruswaysda.github.io/submit-button.html");


        //  Step 2: Click on submit
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
        System.out.println("Clicked Submit button");
        Thread.sleep(500);

        // Switch to the new window
        String mainWindow = driver.getWindowHandle();
        Set<String> windowHandle = driver.getWindowHandles();
        for ( String window : windowHandle) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(window);

            }
        }

        //  Step 3: Verify the new URL contains 'actionsClickDrag'
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after redirect: " + currentUrl);
        Assertions.assertTrue(currentUrl.contains("actionsClickDrag"));
        System.out.println( "URL verification passed!" );



        // Step 4: Drag and Drop
        WebElement DragMe= driver.findElement(By.id("drag1")); //<div id="drag1" class="box" draggable="true">Drag me</div>
        WebElement DropHere = driver.findElement(By.id("drop1")); //<div id="drop1" class="drop-zone">Drop here</div>

        Actions actions = new Actions(driver);
        actions.dragAndDrop(DragMe, DropHere).perform();
        System.out.println("Drag and Drop success");
        Thread.sleep(500);



        // Step 5:  Right-click on 'Right-click' me
        WebElement rightClick = driver.findElement(By.id("showSuccessButton"));//<button id="showSuccessButton" class="action-button">Right-click me</button>
        actions.contextClick(rightClick).perform();
        Thread.sleep(500);


        // Step 6:  Double-click on 'Double-click me'
        WebElement doubleClick = driver.findElement(By.id("doubleClickButton")); //<button id="doubleClickButton" class="action-button">Double-click me</button>
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(500);


        // Step 7: Hover on 'Hover over me'
        WebElement hover = driver.findElement(By.id("hoverButton")); //<button id="hoverButton" class="hover-button">Hover over me</button>
        actions.moveToElement(hover).perform();
        Thread.sleep(500);


        // Step 8: Verify all actions' success messages.

        //Right-click
        Assertions.assertTrue(driver.findElement(By.id("rightClickSuccessMessage")).isDisplayed()); //<div id="rightClickSuccessMessage" class="message" style="display: block;">Button right-clicked!</div>
        System.out.println("Right-click success");

        //Double-click
        Assertions.assertTrue(driver.findElement(By.id("doubleClickSuccessMessage")).isDisplayed()); //<div id="doubleClickSuccessMessage" class="message" style="display: block;">Button double-clicked!</div>
        System.out.println("Double-click success");

        //Hover on
        Assertions.assertTrue(driver.findElement(By.id("hoverSuccessMessage")).isDisplayed()); //<div id="hoverSuccessMessage" class="message" style="display: block;">Button hovered!</div>
        System.out.println("Hover success");


    }
}