package Tests.Assignments.Assignment09;

import Tests.utilities.TestBaseWithActionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.List;
import java.io.File;

public class T03_ExportWebTableToExcel extends TestBaseWithActionHelper {

    @Test
    public void exportTableToExcel() throws Exception {
        Logger logger = LogManager.getLogger(T03_ExportWebTableToExcel.class);
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("Navigated to web table page");

        // Locate Table 1
        WebElement table = driver.findElement(By.id("t1"));

        // Store the Excel file in the resources folder
        String path = Path.of(".", "resources", "ExportTableToExcel.xlsx").toString();
        logger.info("Table 1 exported successfully to resources/ExportTableToExcel.xlsx");

        Workbook workbook;
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = WorkbookFactory.create(fis);
            fis.close();
        } else {
            workbook = WorkbookFactory.create(true);
        }


        Sheet sheet = workbook.createSheet("table_01");

        // Read rows and cells from the web table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);
            List<WebElement> cells = rows.get(i).findElements(By.tagName("th"));
            if (cells.isEmpty()) {
                cells = rows.get(i).findElements(By.tagName("td"));
            }
            for (int j = 0; j < cells.size(); j++) {
                Cell cell = excelRow.createCell(j);
                cell.setCellValue(cells.get(j).getText());
            }
        }

        // Write data to Excel file
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}