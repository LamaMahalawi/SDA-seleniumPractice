package Tests.Junit_Selenium_MorningClass.Day02_Jason;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C03_CSSSelectorTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void cSSSelectorTest() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.cssSelector("#email")).sendKeys("johndoeSDA@yahoo.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("John.123");
        List<WebElement> welcomeMessage = driver.findElements(By.cssSelector(".welcome-message"));
        welcomeMessage.forEach(t-> System.out.println(t.getText()));
    }
    @Test
    void addElementTest(){ // // // // //
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='addElement()']")));

        addButton.click();
        createButtons(50);
        DeleteButtonsAndValidate(40);

    }

    void createButtons(int num){
        for (int i=0; i<num; i++){
            driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        }
    }

    void DeleteButtonsAndValidate (int num) {
        List<WebElement> deletes = driver.findElements(By.cssSelector(" .added-manually"));
        int buttonsBeforeDelete = deletes.size();
        for (int i = 0; i < num; i++) {
            deletes.get(i).click();
        }

        deletes = driver.findElements(By.cssSelector(".added-manually"));
        int buttonsAfterDelete = deletes.size();
        Assertions.assertEquals(buttonsBeforeDelete - buttonsAfterDelete, num);

    }
    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}