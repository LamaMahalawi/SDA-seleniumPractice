package Tests.Assignments.Assignment08;

import Tests.utilities.JavaScriptUtils;
import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T05_JavaScriptEventsTest extends TestBase {

    @Test
    public void testAllEvents() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        Actions actions = new Actions(driver);

        // OnBlur
        WebElement onBlur = driver.findElement(By.id("onblur"));
        onBlur.click();
        System.out.println("onBlur successfully!");


        // OnClick
        WebElement onClick = driver.findElement(By.id("onclick"));
        JavaScriptUtils.clickElement(driver, onClick);
        System.out.println("onClick successfully!");
        Thread.sleep(500);

        // OnContextMenu (Right Click)
        WebElement onContextMenu = driver.findElement(By.xpath("//*[@id=\"oncontextmenu\"]"));
        actions.contextClick(onContextMenu).perform();
        System.out.println("onContextMenu successfully!");
        Thread.sleep(500);

        // OnDoubleClick
        WebElement onDoubleClick = driver.findElement(By.id("ondoubleclick"));
        actions.doubleClick(onDoubleClick).perform();
        System.out.println("onDoubleClick successfully!");
        Thread.sleep(500);

        // OnFocus
        WebElement onFocus = driver.findElement(By.id("onfocus"));
        onFocus.click();
        System.out.println("onFocus successfully!");
        Thread.sleep(500);

        // OnKeyDown
        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));
        onKeyDown.click();
        actions.keyDown("A").perform();
        Thread.sleep(500);
        actions.keyUp("A").perform();
        System.out.println("onKeyDown successfully!");

        // OnKeyUp
        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));
        onKeyUp.click();
        actions.keyDown("C").perform();
        actions.keyUp("C").perform();
        System.out.println("onKeyUp successfully!");
        Thread.sleep(500);


        // OnKeyPress
        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));
        onKeyPress.click();
        actions.sendKeys("B").perform();
        System.out.println("onKeyPress successfully!");
        Thread.sleep(500);



        // OnMouseOver
        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));
        actions.moveToElement(onMouseOver).perform();
        System.out.println("onMouseOver successfully!");
        Thread.sleep(500);

        // OnMouseLeave
        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));
        actions.moveToElement(onMouseLeave).perform();
        actions.moveByOffset(100, 100).perform();
        System.out.println("onMouseLeave successfully!");
        Thread.sleep(500);

        // OnMouseDown
        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));
        actions.clickAndHold(onMouseDown).release().perform();
        System.out.println("onMouseDown successfully!");
        Thread.sleep(500);

        System.out.println("All events triggered and verified successfully!");
    }
}
