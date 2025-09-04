package Tests.Assignments.Assignment01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01ManageWindow {
    public static void main(String[] args) throws InterruptedException {

        //invoke chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open Google home page
        driver.get("https://www.google.com");
        Thread.sleep(1000);

        // Get Title on page
        String Title = driver.getTitle();
        System.out.println("Page Title is : " + Title);

        // Get Current URL on page
        String CurrentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + CurrentURL);


        // Close the page
        driver.close();
        driver.quit();
    }
}