package Tests.Junit_Selenium_MorningClass.Day09;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;



public class C43_TakeScreenShot02 extends TestBase {
    /*
    Go to Linkedin
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void screenShotWithTestBaseTest() throws InterruptedException {
        driver.get("https://www.linkedIn.com");
        Thread.sleep(3000);
        //takeScreenShot(driver);

        WebElement element = driver.findElement(By.xpath("//icon[@data-test-id]"));
        //takeScreenshotOfElement(driver,element);

    }
}
