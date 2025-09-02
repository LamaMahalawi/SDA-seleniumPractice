package Tests;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C07ManageWindow {
        public static void main(String[] args) throws InterruptedException {

            //invoke chrome Browser
            WebDriver driver = new ChromeDriver();

            // Go to the Amazon URL :
            driver.navigate().to("https://www.amazon.com/");
            Thread.sleep(1000);

            // Print the position and size of the page.
            Point dimensions = driver.manage().window().getPosition();
            System.out.println("Dimensions X :" + dimensions.getX());
            System.out.println("Dimensions Y :" + dimensions.getY());
            System.out.println("Dimensions = " + dimensions);


            Point position = driver.manage().window().getPosition();
            System.out.println("position X : " + position.getX());
            System.out.println("position Y : " + position.getY());
            System.out.println("position = " + position);



            // Adjust the position and size of the page as desired.
            driver.manage().window().setPosition(new org.openqa.selenium.Point(position.getX() + 100, position.getY()+ 100 )); //- go to the left + go to the right
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(500, 500));
            Thread.sleep(1000);



            //Test that the page is in the position and size you want.
            System.out.println("New Position : " + driver.manage().window().getPosition());
            System.out.println("New Size : " + driver.manage().window().getSize());


            // Close the page
            driver.close();
            driver.quit();
        }
}

