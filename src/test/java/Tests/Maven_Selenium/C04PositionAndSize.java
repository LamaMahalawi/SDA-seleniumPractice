package Tests.Maven_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;

public class C04PositionAndSize {
    public static void main (String[] args) throws InterruptedException {

        // Go to the w3school URL
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.w3schools.com");
        Thread.sleep(1000);

        // Print the position and size of the page
        Point dimensions = driver.manage().window().getPosition();
        System.out.println("dimensions.getX() = " + dimensions.getX());
        System.out.println("dimensions.getY() = " + dimensions.getY());
        System.out.println("dimensions = " + dimensions);


        Point position = driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position = " + position);
        Thread.sleep(1000);


        // Adjust the position and size of the page as desired
        driver.manage().window().setPosition(new org.openqa.selenium.Point(position.getX()- 50, position.getY()+ 50)); //- go to the left + go to the right
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));
        Thread.sleep(1000);

        // Close the page
        driver.close();
        driver.quit();
    }
}