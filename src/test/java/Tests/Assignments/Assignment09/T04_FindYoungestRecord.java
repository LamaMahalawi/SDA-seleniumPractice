package Tests.Assignments.Assignment09;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Tests.utilities.TestBaseWithActionHelper;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class T04_FindYoungestRecord extends TestBaseWithActionHelper {

    @Test
    public void findYoungestRecord() throws Exception {
        Logger logger = LogManager.getLogger(T04_FindYoungestRecord.class);


        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("Navigated to Add Record Web Table page");

        Faker faker = new Faker();
        Random random = new Random();

        //  Add 10 records using Faker
        for (int i = 0; i < 10; i++) {
            String name = faker.name().firstName();
            int age = faker.number().numberBetween(10, 50);

            driver.findElement(By.id("nameInput")).clear();
            driver.findElement(By.id("nameInput")).sendKeys(name);

            driver.findElement(By.id("ageInput")).clear();
            driver.findElement(By.id("ageInput")).sendKeys(String.valueOf(age));

            // Dropdown select (choose random country)
            WebElement countryElement = driver.findElement(By.id("countrySelect"));
            Select countrySelect = new Select(countryElement);
            int optionIndex = 1 + random.nextInt(countrySelect.getOptions().size() - 1);
            countrySelect.selectByIndex(optionIndex);
            Thread.sleep(200);

            // Click Add button
            driver.findElement(By.xpath("/html/body/div/button")).click();
            logger.info("Record added successfully");

        }

        // Read all rows from the table
        List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='tableBody']/tr"));

        // Find the name of the youngest record
        int youngestAge = Integer.MAX_VALUE;
        String youngestName = "";
        String youngestCountry = "";

        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("./td[1]")).getText();
            int age = Integer.parseInt(row.findElement(By.xpath("./td[2]")).getText());
            String country = row.findElement(By.xpath("./td[3]")).getText();

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
                youngestCountry = country;
            }
        }
        logger.info("The youngest record is: Name={}, Age={}, Country={}", youngestName, youngestAge, youngestCountry);
    }
}