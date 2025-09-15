package Tests.Mentoring.Day07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class T01_JScriptExecutorTest extends TestBase {

    //Create a method to change border color and style of web elements.
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.cssText += 'border: 4px solid navy !important; background-color: Teal !important;';", element);
    }

    @Test
    public void testSignIn() throws InterruptedException {
        // Step 1: Go to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2: nter username 'admin'
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        highlightElement(username);
        username.sendKeys("admin");
        Thread.sleep(500);
        System.out.println("Entered username");

        // Step 3: enter password '123'
        WebElement password = driver.findElement(By.id("password"));
        highlightElement(password);
        Thread.sleep(500);
        password.sendKeys("123");
        System.out.println("Entered password");

        // Step 4: Click on Sign In
        WebElement signInBtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/input[2]"));
        highlightElement(signInBtn);
        signInBtn.click();
        Thread.sleep(500);
        System.out.println("Clicked Sign In");

        // Step 5: Assert the 'Employee Table' is visible
        WebElement empTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#employeeTable")));
        Assertions.assertTrue(empTable.isDisplayed());
        highlightElement(empTable);
        Thread.sleep(700);
        System.out.println("Employee Table is visible");
    }
}

