package Tests.Mentoring.Day05_Extends;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;


public class T03_DeleteCharsTest extends TestBase {

     /*
    Go to https://claruswaysda.github.io/deleteChars.html
    Enter your full name
    Delete the letters
    Verify the message 'Deleted'
    */

    By field = By.xpath("//input[@type='text']");
    By EnterButton = By.id("enterButton");
    By DeleteButton = By.id("deleteButton");
    By messageId = By.id("deletedMessage");
    String DeletedMessage = "Deleted";
    String NameExample = "Lama";

    @Test
    void test03() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/deleteChars.html");

        //Enter your full name
        driver.findElement(field).sendKeys(NameExample);
        driver.findElement(EnterButton).click();
        System.out.println("The Enter Name is = " + NameExample);
        Thread.sleep(500);

        //Delete the letters
        for(int i= 0 ; i < NameExample.length(); i++){
            driver.findElement(DeleteButton).click();
            Thread.sleep(500);
        }

        //Verify the message 'Deleted'
        String message = driver.findElement(messageId).getText();
        System.out.println("Result message:" + message);
        Assertions.assertEquals(DeletedMessage,message);
        Thread.sleep(500);
    }
}