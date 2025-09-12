package Tests.Junit_Selenium_MorningClass.Day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Tests.utilities.TestBase;

public class C28_ScrollActions extends TestBase {
    String url = "https://www.browserstack.com";
    By testimonialsBy = By.id("testimonials-body");


   @Test
    public void scrollTest() throws InterruptedException {
        driver.get(url);

        Actions actions = new Actions(driver);
       // JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll page down with 'page down' key
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        // Scroll page down with 'down arrow' key
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        // Scroll page up with 'up arrow' key
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);

        // Scroll page up with 'page up' key
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);

        // Scroll page down with 'space' key
        actions.sendKeys(Keys.SPACE).perform();
        Thread.sleep(2000);

        // Scroll to bottom of the page


        // Scroll to view of an element
        actions.scrollToElement(driver.findElement(testimonialsBy)).perform();
        Thread.sleep(2000);

        // Scroll to top of the page


        // Scroll with moveToElement


        // Scroll by some amount down
        actions.scrollByAmount(0,200).perform();

        // Scroll by some amount up

    }
}

