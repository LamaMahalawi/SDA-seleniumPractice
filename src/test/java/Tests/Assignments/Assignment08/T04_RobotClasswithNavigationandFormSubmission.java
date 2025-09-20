package Tests.Assignments.Assignment08;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class T04_RobotClasswithNavigationandFormSubmission extends TestBase {

    @Test
    public void testRobotLogin() throws AWTException, InterruptedException {

        // Step 1: Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
        driver.get("https://the-internet.herokuapp.com/login");


        // Step 2: Click into the username field and Type the username using sendKeys.
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.click();
        usernameField.sendKeys("tomsmith");
        System.out.println("Entered username");
        Thread.sleep(500);

        // Step 3: Use the Robot class to:
        Robot robot = new Robot();
        Thread.sleep(500);

        // Press Tab → go to password field.
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);

        // Type the password using sendKeys.
        WebElement passwordField = driver.switchTo().activeElement(); // focus is now on password
        passwordField.sendKeys("SuperSecretPassword!");
        System.out.println("Entered password");
        Thread.sleep(500);

        // Press Enter → submit the form.
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("Submitted the form using Enter");

        Thread.sleep(1000);

        // Step 4: Verify login success or error message.
        WebElement flashMessage = driver.findElement(By.id("flash"));
        System.out.println(flashMessage.getText());
        Thread.sleep(1000);

    }
}
