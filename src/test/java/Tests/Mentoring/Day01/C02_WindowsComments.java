package Tests.Mentoring.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_WindowsComments {
    public static void main (String[] args) throws InterruptedException {

        //invoke chrome Browser
        WebDriver driver = new ChromeDriver();

        //Navigate to URL yahoo
        driver.navigate().to("https://www.yahoo.com");


        // Maximize Window
       driver.manage().window().maximize();
       Thread.sleep(1000);

        //Navigate to URL amazon
        driver.navigate().to("https://www.amazon.com");

        // Minimize Window
        driver.manage().window().minimize();
        Thread.sleep(1000);

        //Come back
        driver.navigate().back();
        Thread.sleep(1000);

        //Again go back
        driver.navigate().forward();
        Thread.sleep(1000);

        //Refresh the Browser
        driver.navigate().refresh();
        Thread.sleep(1000);


        //close the Pag
        driver.close(); // Close the active ATB
        driver.quit(); //Terminates the session so closes all tabs
    }
}
