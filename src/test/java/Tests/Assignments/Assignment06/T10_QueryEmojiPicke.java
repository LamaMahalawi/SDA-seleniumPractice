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



    By Text = By.id("text");
    By NameOfFood = By.id("food");

    @Test
    void testEmoojis() throws InterruptedException {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        System.out.println("Opened demo page successfully");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // 1. Switch to iframe by cssSelector
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='emojis_frame']")));
        System.out.println("Switched to iframe");



        // 2. Click on the second emoji (animals and nature)
        driver.findElement(By.cssSelector("a[href='#nature']")).click();
        System.out.println("Clicked on second emoji category");



        // 3. Click on all second emoji items
        List<WebElement> emojis = driver.findElements(By.cssSelector("#nature img"));
        System.out.println("Found " + emojis.size() + " emojis under 'animals and nature'");

        for (int i = 0; i < emojis.size(); i++) {
            WebElement emoji = emojis.get(i);
            // wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(emoji));
            emoji.click();
            Thread.sleep(100);
        }
        System.out.println("All emojis under 'animals and nature' clicked successfully");


        // Step 4. Return to the parent iframe
        driver.switchTo().defaultContent();
        System.out.println("Returned to parent frame");


        // Step 5. Fill out the form ( 2 ONLY )
        driver.findElement(Text).sendKeys("Lama");
        driver.findElement(NameOfFood).sendKeys("food");
        Thread.sleep(1000);

        //press the apply button
        driver.switchTo().defaultContent();
        WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[normalize-space()='Apply' or normalize-space()='APPLY']"))));
        Thread.sleep(500);
        applyBtn.click();
        System.out.println("Clicked Apply button");
    }}