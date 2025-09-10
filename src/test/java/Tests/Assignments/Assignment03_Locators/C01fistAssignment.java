package Tests.Assignments.Assignment03_Locators;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class C01fistAssignment {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void absoluteXPathTest() {

        System.out.println("Starting Absolute XPath Test :");

        // TODO: Locate username using absolute XPath
        WebElement username = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));

        // TODO: Locate password using absolute XPath
        WebElement password = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

        // TODO: Locate login button using absolute XPath
        WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

        // TODO: Test both approaches work
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-topbar-header-breadcrumb-module")));
        Assertions.assertTrue(dashboardHeader.isDisplayed());

        System.out.println("Login successful, Dashboard is displayed");
    }

    @Test
    void relativeXPathTest() {

        System.out.println("Starting Relative XPath Test :");

        // TODO: Locate username using relative XPath
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));

        // TODO: Locate password using relative XPath
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        // TODO: Locate login button using relative XPath
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        username.sendKeys("Admin");
        password.sendKeys("admin123", Keys.ENTER);

        // TODO: Test both approaches work
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-topbar-header-breadcrumb-module")));
        Assertions.assertTrue(dashboardHeader.isDisplayed());

        System.out.println("Login successful, Dashboard is displayed");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}