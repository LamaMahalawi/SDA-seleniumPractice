package Tests.Assignments.Assignment06;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class T10_QueryEmojiPicke extends TestBase {

    @Test
    void testEmoojis() throws InterruptedException {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        System.out.println("Opened demo page");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Switch to iframe by index
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='emojis_frame']")));
        System.out.println("Switched to iframe");



        // Click on the second emoji category (Nature)
        driver.findElement(By.cssSelector("a[href='#nature']")).click();
        System.out.println("Clicked on second emoji category");





        // Step 3: Click all emojis under the "nature" tab safely
        List<WebElement> emojis = driver.findElements(By.cssSelector("#nature img"));
        System.out.println("Found " + emojis.size() + " emojis under #nature");

        for (int i = 0; i < emojis.size(); i++) {
            WebElement emoji = emojis.get(i);
            // wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(emoji));
            emoji.click();
            Thread.sleep(100);
        }
        System.out.println("All emojis under #nature clicked successfully");




        // Return to parent frame
        driver.switchTo().defaultContent();
        System.out.println("Returned to parent frame");


        // Step 5: Return to parent frame and click Apply button
        driver.switchTo().defaultContent();
        WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//button[normalize-space()='Apply' or normalize-space()='APPLY']"))));
        applyBtn.click();
        System.out.println("Clicked Apply button");
    }}