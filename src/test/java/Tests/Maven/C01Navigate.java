package Tests.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01Navigate {
    public static void main (String[] args) throws InterruptedException {

        //invoke chrome Browser
        WebDriver driver = new ChromeDriver();

        //Navigate to URL
        driver.navigate().to("https://www.w3schools.com");
        driver.get("https://stackoverflow.com");

        //Come back to w3schools
        driver.navigate().back();
        Thread.sleep(1000); //temporarily pauses the current step, and once the time is over, the code continues to the next step.

        //Again go back to stackoverflow
        driver.navigate().forward();
        Thread.sleep(1000);


        //Refresh the Browser
        driver.navigate().refresh();
        Thread.sleep(1000); // The alternative to sleep is using debug from right mouse click


        //close the Browser
        driver.close(); // Close the active ATB
        driver.quit(); //Terminates the session so closes all tab

    }
}
