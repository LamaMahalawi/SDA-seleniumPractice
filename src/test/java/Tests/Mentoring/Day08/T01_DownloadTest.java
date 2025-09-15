package Tests.Mentoring.Day08;

import Tests.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T01_DownloadTest extends TestBase {

    @Test
    public void testDownloadFile() throws InterruptedException, IOException {

        // Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        // Click the download button
        driver.findElement(By.xpath("//*[@id=\"uploadForm\"]/div[1]/a")).click();
        Thread.sleep(3000);

        // Verify that the file exists in the Downloads folder
        Path filePath = Path.of(System.getProperty("user.home"), "Downloads", "QAProgram.png");
        Assertions.assertTrue(Files.exists(filePath));
        Files.deleteIfExists(filePath);
    }
}