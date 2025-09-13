package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class T01_WindowHandlePractice extends TestBase {

    @Test
    void testWindowHandlePractice() throws InterruptedException {

        // Step 1: Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");

        // Step 2: Click on 'Window Handle'
        driver.findElement(By.xpath("/html/body/div/div[24]/a")).click();
        System.out.println("Clicked 'Window Handle'");

        // Switch to new window
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(200);
        System.out.println("Switched to 'Window Handle'");

        // Step 3: Click on 'Open Index Page'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement openIndexBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("openIndex")));
        openIndexBtn.click();
        System.out.println("Clicked 'Open Index Page'");


        // Switch to the opened index page
        Set<String> windowsAfterIndex = driver.getWindowHandles();
        for (String window : windowsAfterIndex) {
            if (!window.equals(mainWindow) && !window.equals(driver.getWindowHandle())) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(200);
        System.out.println("Switched to 'Open Index Page'");

        // Step 6: Verify 'https://claruswaysda.github.io/index.html'
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assertions.assertTrue(currentUrl.contains("index.html"));
        System.out.println("URL verification passed");
    }}