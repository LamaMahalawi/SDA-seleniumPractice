package Tests.Assignments.Assignment01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04ManageGoogleWindow {
    public static void main(String[] args) throws InterruptedException {

        //invoke chrome Browser
        WebDriver driver = new ChromeDriver();

        // Go to the Amazon URL :
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(1000);

        // Maximize the window
        driver.manage().window().maximize();

        // Print the position and size of the page
        Dimension Size = driver.manage().window().getSize();
        System.out.println("Current size = " + Size);

        Point position = driver.manage().window().getPosition();
        System.out.println("Current position = " + position);

        // Minimize the page
        driver.manage().window().minimize();

        // Wait 5 seconds
        Thread.sleep(5000);

        // Maximize the window after 5 seconds
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Print the position and size of the page
        Dimension Size2 = driver.manage().window().getSize();
        System.out.println("After maximize size = " + Size2);

        Point position2 = driver.manage().window().getPosition();
        System.out.println("After maximize position = " + position2);

        //Make the page fullscreen
        driver.manage().window().fullscreen();

        // Close the page
        driver.close();
        driver.quit();
    }
}

