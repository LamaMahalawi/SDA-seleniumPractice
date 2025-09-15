package Tests.Mentoring.Day07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;

public class T02_UploadAndClose extends TestBase {
    @Test
    void testUploadAndClose() throws InterruptedException, AWTException {
        // Step 1: Open the page
        driver.get("https://claruswaysda.github.io/downloadUpload.html");


        // Step 2: Click on 'Upload' button
        WebElement uploadBtn = driver.findElement(By.xpath("//*[@id=\"uploadForm\"]/div[2]/label"));
        uploadBtn.click();
        System.out.println("Clicked 'Upload' button");
        Thread.sleep(500);

        // Step 3: Close the opening page using CTRL + F4 via Robot FOR Windows
       Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
        System.out.println("Closed the page using CTRL + F4 (Robot)");

        // Step 3: Close the opening page using CTRL + F4 via Robot FOR MAC
        /*Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_META);*/

    }
}

