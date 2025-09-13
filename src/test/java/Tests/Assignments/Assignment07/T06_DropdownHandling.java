package Tests.Assignments.Assignment07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import Tests.utilities.TestBase;

public class T06_DropdownHandling extends TestBase {


    @Test
    public void testDropdowns() throws InterruptedException {

        // Go to https://claruswaysda.github.io/Dropdowns.html
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

        // 1. Traditional Dropdown - select 'Ford'
        Select traditionalDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"carSelect\"]")));
        traditionalDropdown.selectByVisibleText("Ford");
        System.out.println("Selected Ford in traditional dropdown");

        // 2. Multi-Select Dropdown - select 'Mercedes'
        Select multiSelect = new Select(driver.findElement(By.xpath("//*[@id=\"multiCarSelect\"]")));
        multiSelect.selectByVisibleText("Mercedes");
        System.out.println("Selected Mercedes in multi-select dropdown");

        // 3. Custom Dropdown (Bootstrap-like) - select 'BMW'
        WebElement customDropdown = driver.findElement(By.xpath("//*[@id=\"customDropdown\"]"));
        customDropdown.click();

        WebElement optionBMW = driver.findElement(By.xpath("//*[@id=\"customList\"]/div[2]"));
        optionBMW.click();
        System.out.println("Selected BMW in custom dropdown");

        // 4. Static Auto-Suggest Dropdown - select 'Tesla Model 3'
        WebElement staticAuto = driver.findElement(By.xpath("//*[@id=\"staticInput\"]"));
        staticAuto.sendKeys("Tesla Model 3");
        staticAuto.sendKeys(Keys.ENTER);
        System.out.println("Selected Tesla Model 3 in static auto-suggest");

        // 5. Dynamic Auto-Suggest Dropdown - select 'Toyota'
        WebElement dynamicAuto = driver.findElement(By.xpath("//*[@id=\"dynamicInput\"]"));
        dynamicAuto.sendKeys("Toyota");
        dynamicAuto.sendKeys(Keys.ENTER);
        System.out.println("Selected Toyota in dynamic auto-suggest");

        Thread.sleep(500);
    }
}
