package Tests.Mentoring.Junit.Day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;


public class C02_CalculatorOperationsTest {
    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    By firstInput = By.id("number1");
    By secondInput = By.id("number2");
    String num1 = "20";
    String num2 = "5";
    String[] operations = {"plus","minus","times","divide"};
    double addResult = Double.parseDouble(num1) + Double.parseDouble(num2);
    double subResult = Double.parseDouble(num1) - Double.parseDouble(num2);
    double mulResult = Double.parseDouble(num1) * Double.parseDouble(num2);
    double divResult = Double.parseDouble(num1) / Double.parseDouble(num2);


    @Test
    void test() throws InterruptedException {

        //   Go to https://testpages.eviltester.com/styled/calculator
        driver.get(url);

        //   Type any number in first and second input
        driver.findElement(firstInput).sendKeys(num1);
        driver.findElement(secondInput).sendKeys(num2);

        //   Click Calculate for each operation

        for(int i=0; i<operations.length; i++){

            driver.findElement(firstInput).clear();
            driver.findElement(firstInput).sendKeys(num1);
            driver.findElement(secondInput).clear();
            driver.findElement(secondInput).sendKeys(num2);

            WebElement op = driver.findElement(By.id("function"));
            Select select = new Select(op);
            select.selectByValue(operations[i]);
            driver.findElement(By.id("calculate")).click();

            //   Get and verify results for all operations
            switch (operations[i]) {
                case "plus" -> {
                    String additionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals("25", additionResult);
                    System.out.println("Addition Result: " + additionResult); // 20 + 5
                    Thread.sleep(2000);
                }
                case "minus" -> {
                    String subtractionResult = driver.findElement(By.id("answer")).getText();
                    System.out.println("Subtraction Result: " + subtractionResult); // 20 - 5
                    Thread.sleep(2000);
                }
                case "times" -> {
                    String multiplicationResult = driver.findElement(By.id("answer")).getText();
                    System.out.println("Multiplication Result: " + multiplicationResult); // 20 * 5
                    Thread.sleep(2000);
                }
                case "divide" -> {
                    String divisionResult = driver.findElement(By.id("answer")).getText();
                    System.out.println("Division Result: " + divisionResult); // 20 / 5
                    Thread.sleep(2000);
                }
            }
        }
    }

    @BeforeEach
    void setUp () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown () {
        driver.quit();
    }
}