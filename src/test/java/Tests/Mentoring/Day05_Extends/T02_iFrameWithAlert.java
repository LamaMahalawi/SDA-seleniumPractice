package Tests.Mentoring.Day05_Extends;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import Tests.utilities.TestBase;

public class T02_iFrameWithAlert extends TestBase {
    //Go to https://claruswaysda.github.io/iframe.html
    //Type your name in input
    //Click on 'Bold' button
    //Assert the alert message


    @Test
    void test() throws InterruptedException {

        driver.get("https://claruswaysda.github.io/iframe.html");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("/html/body/input")).sendKeys("Lama");
        Thread.sleep(500);



        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/button")).click();


        Assertions.assertEquals(driver.switchTo().alert().getText(),"Bold button clicked");
        driver.switchTo().alert().accept();
    }}