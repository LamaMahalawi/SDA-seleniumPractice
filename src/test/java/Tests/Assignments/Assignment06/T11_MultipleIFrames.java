package Tests.Assignments.Assignment06;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class T11_MultipleIFrames extends TestBase {

    @Test
    void testMultipleIframesSimple() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 1. Find the number of iframes on the page
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + frames.size());

        // 2. Switch to the (JMeter Made Easy)
        driver.switchTo().frame(frames.get(1));
        System.out.println("Switched to the (JMeter Made Easy)");

        // 3. Click the link
        driver.findElement(By.xpath("//a[contains(@href, 'live-selenium-project.html')]")).click();
        System.out.println("Clicked the link (https://www.guru99.com/live-selenium-project.html)");

        // 4. Exit the frame and return to the main page
        driver.switchTo().defaultContent();
        System.out.println("Returned to main page");

        Thread.sleep(1000);
    }
}