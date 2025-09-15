package Tests.Mentoring.Day07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class T03_Cookies extends TestBase {


    @Test
    public void testCookies() throws InterruptedException {
        // Step 1: Open the page
        driver.get("https://claruswaysda.github.io/CookiesWait.html");
        Thread.sleep(700);

        // Step 2: Accept alert if present
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            System.out.println("Alert accepted");
        } catch (Exception Error) {
            System.out.println("No alert present");
        }
        Thread.sleep(700);

        // Step 3: Print all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies before deletion:");
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
        Thread.sleep(200);

        // Step 4: Delete all cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(200);
        System.out.println("All cookies deleted");

        // Step 5: Assert cookies are deleted
        Set<Cookie> cookiesAfter = driver.manage().getCookies();
        Assertions.assertTrue(cookiesAfter.isEmpty());
        Thread.sleep(200);
        System.out.println("All cookies are deleted successfully");
    }
}
