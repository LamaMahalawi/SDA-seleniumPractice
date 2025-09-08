package Tests.Mentoring.Junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01JunitTests01 {


// Go to YouTube homepage
// Do the following tasks by creating 4 different test methods.
// Print "Test is running" before each test() method
//Print "Test finished" after each test() method
// Test if the currentURL contains "youtube"
// Test if the title does not contain "Video".
// Test if the URL contains "youtube".
// Test if the sourcePage contains "youtube".


        static WebDriver driver;

        @Test
        public void URLtest1() {
            System.out.println("Current URL contains 'youtube'");
            String URL = driver.getCurrentUrl();
            Assertions.assertTrue(URL.contains("youtube"));

        }


        @Test
        public void URLtest2() {
            System.out.println("Title dosent contains 'video'");
            String title = driver.getTitle();
            Assertions.assertFalse(title.contains("video"));
        }


        @Test
        public void titleTest() {
            System.out.println("Current URL contains 'youtube' ");
            String URL = driver.getCurrentUrl();
            Assertions.assertTrue(URL.contains("youtube"));

        }

        @Test
        public void PageSourceTest() {
            System.out.println("source Page contains 'youtube'");
            Assertions.assertTrue(driver.getPageSource().contains("youtube"));

        }

        @BeforeEach
        void beforEach() {
            System.out.println("Test is running");
        }

        @AfterEach
        void AfterEach (){
            System.out.println("Test finished");

        }

        @BeforeAll
        public static void setUp (){
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.youtube.com/");
        }

        @AfterAll
        public static void tearDown (){
            driver.quit();


        }
    }