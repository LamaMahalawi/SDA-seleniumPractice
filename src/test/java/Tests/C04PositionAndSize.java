package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04PositionAndSize {
    public static void main (String[] args) throws InterruptedException {

        // Go to the w3school URL
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.w3schools.com");
        Thread.sleep(1000);

        // Print the position and size of the page
        System.out.println("Current Position: " + driver.manage().window().getPosition());
        System.out.println("Current Size: " + driver.manage().window().getSize());
        Thread.sleep(1000);

        // Adjust the position and size of the page as desired
        driver.manage().window().setPosition(new Point(100, 50));
        driver.manage().window().setSize(new Dimension(1024, 768));
        Thread.sleep(1000);

        // Test that the page is in the position and size you want
        if(driver.manage().window().getPosition().equals(new Point(100,50)) &&
                driver.manage().window().getSize().equals(new Dimension(1024,768))) {
            System.out.println("Window position and size are correct ");

        } else {
            System.out.println("Window position or size are incorrect");
        }
        Thread.sleep(1000);

        // Close the page
        driver.close();
        driver.quit();
    }
}
