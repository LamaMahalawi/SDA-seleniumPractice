package Tests.Mentoring.Day05;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class T01_ActionsFormTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill the form
    Generate Passcode
    Use passcode to submit form
     */

    By nameId = By.id("name");
    By ageId = By.id("age");
    By selectID = By.id("options");
    By checkbox1value = By.xpath("//label[normalize-space()='Coding']");
    By checkbox2value = By.xpath("//*[@id=\"myForm\"]/div[3]/label[2]/input");
    By checkbox3value = By.xpath("//label[.=' Management']");
    By radioMale = By.xpath("//input[@value='male']");
    By radioFemale = By.xpath("//input[@value='female']");
    By radioOther = By.xpath("//input[@value='other']");
    By submitButton = By.xpath("//button[@type='button']");

    @Test
    void test01() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");
        driver.findElement(nameId).sendKeys("Lama");
        driver.findElement(ageId).sendKeys("23");
        Thread.sleep(1500);

        Select select = new Select(driver.findElement(selectID));
        select.selectByValue("it");
        Thread.sleep(1500);

        //driver.findElement(checkbox1value).click();
        driver.findElement(checkbox2value).click();
        Thread.sleep(1500);

        //driver.findElement(checkbox3value).click();
        driver.findElement(radioFemale).click();
        Thread.sleep(1500);

        driver.findElement(submitButton).click();


        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String passcode = alertText.substring(alertText.indexOf(":") +1).trim();
        System.out.println("Passcode is: " + passcode);
        alert.accept();
        alert.sendKeys(passcode);
        alert.accept();
    }
}