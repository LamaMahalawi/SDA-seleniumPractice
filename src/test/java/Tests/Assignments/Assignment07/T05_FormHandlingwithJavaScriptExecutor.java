package Tests.Assignments.Assignment07;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class T05_FormHandlingwithJavaScriptExecutor extends TestBase {

    // Create a method to flash the elements you are working on and use it.
    public void flashElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getCssValue("backgroundColor");
            js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red; background-color: Teal ;');", element);
            js.executeScript("setTimeout(() => { arguments[0].setAttribute('style', arguments[1]); }, 500);", element, originalStyle);

    }

    @Test
    void testFormHandling() throws InterruptedException {

        // Go to https://claruswaysda.github.io/form.html
        driver.get("https://claruswaysda.github.io/form.html");

        // Register a user
        String ssn = "123-45-6789";
        String firstName = "Lama";
        String lastName = "Mahalawi";
        String address = "Riyadh";
        String phone = "0555555555";
        String username = "lama_2003";
        String email = "lamatest@example.com";
        String password = "123456789";

        WebElement ssnField = driver.findElement(By.id("ssn")); //<input type="text" id="ssn" name="ssn" required="">
        flashElement(ssnField);
        ssnField.sendKeys(ssn);
        Thread.sleep(500);

        WebElement firstNameField = driver.findElement(By.id("first-name")); //<input type="text" id="first-name" name="first-name" required="">
        flashElement(firstNameField);
        firstNameField.sendKeys(firstName);
        Thread.sleep(500);

        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        flashElement(lastNameField);
        lastNameField.sendKeys(lastName);
        Thread.sleep(500);

        WebElement addressField = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        flashElement(addressField);
        addressField.sendKeys(address);
        Thread.sleep(500);

        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        flashElement(phoneField);
        phoneField.sendKeys(phone);
        Thread.sleep(500);

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        flashElement(usernameField);
        usernameField.sendKeys(username);
        Thread.sleep(500);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        flashElement(emailField);
        emailField.sendKeys(email);
        Thread.sleep(500);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        flashElement(passwordField);
        passwordField.sendKeys(password);
        Thread.sleep(500);

        WebElement passwordConfirmField = driver.findElement(By.xpath("//*[@id=\"confirm-password\"]"));
        flashElement(passwordConfirmField);
        passwordConfirmField.sendKeys(password);
        Thread.sleep(500);

        // Click Register button
        WebElement registerButton= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/button"));
        flashElement(registerButton);
        registerButton.click();
        Thread.sleep(500);
        System.out.println("Registration submitted successfully");


        // Step 4: Login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"successMessage\"]/button"));
        flashElement(loginButton); loginButton.click();


        WebElement loginUsername = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        flashElement(loginUsername); loginUsername.sendKeys(username);
        Thread.sleep(500);

        WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        flashElement(loginPassword);loginPassword.sendKeys(password);
        Thread.sleep(500);


        // Click login button
        WebElement login = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button"));
        flashElement(login); login.click();
        System.out.println("Login submitted successfully");
        Thread.sleep(500);

        // Step 5: Celebrate login
        System.out.println("Login celebration done");
    }
}