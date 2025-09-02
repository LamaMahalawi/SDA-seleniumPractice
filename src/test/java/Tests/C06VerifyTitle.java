package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C06VerifyTitle {
    public static void main (String[] args) throws InterruptedException {

        // invoke FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open URL of Website
        //driver.navigate().to("https://www.youtube.com");
        driver.navigate().to("https://youtu.be/QjuG1BIcq6k?si=jt-_zKQr6YYGAlwp");
        Thread.sleep(1000);

        //Get title
        String Title = driver.getTitle();
        System.out.println("Page Title is : " + Title );

        // Verify title contains the word "video"
        if (Title.toLowerCase().contains("video")) {
            System.out.println("Test Passed: Title contains 'video'");
        } else {
            System.out.println("Test Failed: Title does not contain 'video'");
        }


        //close the Pag
        driver.close(); // Close the active ATB
        driver.quit(); //Terminates the session so closes all tabs
}
}
