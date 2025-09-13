package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class T01_WindowHandlePractice extends TestBase {

    By openIndex = By.cssSelector("#openIndex");
    String url = "https://claruswaysda.github.io/";
    By WindowHandle = By.xpath("/html/body/div/div[24]/a");

    @Test
    void testWindowHandlePractice() {
        driver.get(url);

        // Click on Window Handle
        driver.findElement(WindowHandle).click();

         // Used ArrayList so that we can access any window by its number (index).
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        // Click on 'Open Index Page'
        driver.findElement(openIndex).click();


        windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(windows.size() - 1));

        // Verify the link 'https://claruswaysda.github.io/index.html'
        Assertions.assertEquals("https://claruswaysda.github.io/index.html", driver.getCurrentUrl());
        System.out.println("Verification successful");
    }}