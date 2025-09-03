package Tests.Junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05JunitTests05 {

    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        // Launch Chrome
        driver = new ChromeDriver();
        Thread.sleep(1000);
    }

    @Test
    void test01_setWindowSize() throws InterruptedException {
        System.out.println("Navigating to BBC website");
        driver.get("https://www.bbc.com");
        Thread.sleep(1000);

        System.out.println("Setting window size to 800x600");
        driver.manage().window().setSize(new Dimension(800, 600));
        Thread.sleep(1000);

        Dimension size = driver.manage().window().getSize();
        System.out.println("Current window size: " + size);

        Assertions.assertEquals(800, size.getWidth(), "Width is not 800");
        Assertions.assertEquals(600, size.getHeight(), "Height is not 600");
        System.out.println("Window size verified ");
    }

    @Test
    void test02_setWindowPosition() throws InterruptedException {
        System.out.println("Moving window to position (100, 100)");
        driver.manage().window().setPosition(new Point(100, 100));
        Thread.sleep(1000);

        Point position = driver.manage().window().getPosition();
        System.out.println("Current window position: " + position);

        Assertions.assertEquals(100, position.getX(), "X position is not 100");
        Assertions.assertEquals(100, position.getY(), "Y position is not 100");
        System.out.println("Window position verified ");
}

    @AfterEach
    void tearDown() {
        // Close browser
        driver.quit();
    }
}
