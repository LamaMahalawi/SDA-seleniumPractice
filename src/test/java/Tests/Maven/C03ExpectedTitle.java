package Tests.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03ExpectedTitle {

    public static void main (String[] args) throws InterruptedException {

        // Expected Title
        String ExpectedTitle = "Amazon.com"; //Amazon.com

        // Launch Chrome browser (invoke)
        WebDriver driver = new ChromeDriver();

        // Open URL of Website
        driver.navigate().to("https://www.amazon.com");

        // Maximize Window
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //Get title
        String Title = driver.getTitle();
        System.out.println("Page Title is : " + Title );

        // Validate/Compare Page Title
        if ( Title.equals (ExpectedTitle)) {
            System.out.println("Your title is : " + ExpectedTitle + " " + "Title is correct");
        } else {
            System.out.println("Your title is : " + ExpectedTitle + " " + "So your Title is incorrect");
        }


        //close the Pag
        driver.close(); // Close the active ATB
        driver.quit(); //Terminates the session so closes all tabs





}
}