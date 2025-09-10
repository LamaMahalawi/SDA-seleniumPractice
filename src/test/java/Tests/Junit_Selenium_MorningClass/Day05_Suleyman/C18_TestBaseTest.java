package Tests.Junit_Selenium_MorningClass.Day05_Suleyman;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class C18_TestBaseTest extends TestBase {
    @Test
    void test01() {
        driver.get("https://www.linkedIn.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }
    @Test
    void test02() {
        driver.get("https://www.instagram.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }
    @Test
    void test03() {
        driver.get("https://www.google.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
