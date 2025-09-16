package Tests.Junit_Selenium_MorningClass.Day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Tests.utilities.TestBase;

public class C27_HoverOver extends TestBase {
    /*Go to URL: https://www.browserstack.com/
    Hover over on “Products” link.
    Click on "Automate".
    Verify the page URL contains “automate”.*/


    By productsLinkId = By.id("products-dd-toggle");
    By automateLinkXpath = By.xpath("//div[@id='products-dd-tabpanel-1-inner-1']//span[.='Automate']");
    String url = "https://www.browserstack.com/";

    @Test
    public void hoverOverTest() throws InterruptedException {


        ///Go to URL: https://www.browserstack.com/
        driver.get(url);

        //Hover over on “Products” link.
        WebElement productsLink = driver.findElement(productsLinkId);
        Actions actions = new Actions(driver);
        actions.moveToElement(productsLink).perform();


        Thread.sleep(2000);

        //Click on "Automate".
        WebElement automateLink = driver.findElement(automateLinkXpath);
        automateLink.click();

        // Verify the page URL contains “automate”
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("automate"));


    }
}