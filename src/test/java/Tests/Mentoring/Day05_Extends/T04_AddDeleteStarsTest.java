package Tests.Mentoring.Day05_Extends;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import java.util.List;

public class T04_AddDeleteStarsTest extends TestBase {
       /*
    Task 4: Add/Delete Stars
    Go to https://claruswaysda.github.io/addDeleteStar.html
    Create a method to add given number of stars
    Create a method to delete given numbers of stars
    Create a method to verify the given number of stars deleted
    */

    String url = "https://claruswaysda.github.io/addDeleteStar.html";

    By addStarButtonById = By.id("push-button");
    By deleteStarButtonById = By.id("delete-button");
    By starsByXpath = By.xpath("//div[@class='star']");

    // Method to add stars
    void addStars(int addNum) {
        WebElement addButton = driver.findElement(addStarButtonById);
        for (int i = 0; i < addNum; i++) {
            addButton.click();
        }
    }

    // Method to delete stars
    void deleteStars(int deleteNum) {
        WebElement deleteButton = driver.findElement(deleteStarButtonById);
        for (int i = 0; i < deleteNum; i++) {
            deleteButton.click();
        }
    }

    // Method to verify remaining stars
    void verifyStarsAfterDeleted(int expectedCount) {
        List<WebElement> stars = driver.findElements(starsByXpath);
        Assertions.assertEquals(expectedCount, stars.size());
    }

    @Test
    void testAddDeleteStars() {
        driver.get(url);

        addStars(5);

        deleteStars(2);
        verifyStarsAfterDeleted(3);

        deleteStars(3);
        verifyStarsAfterDeleted(0);
    }
}