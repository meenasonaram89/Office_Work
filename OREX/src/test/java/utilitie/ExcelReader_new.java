package utilitie;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader_new {

    // Method to get data from a specific cell
    public static String getCellValue(String filePath, String sheetName, int row, int col) {
        String value = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(sheet.getRow(row).getCell(col));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    // Method to get the total number of data rows
    public static int getRowCount(String filePath, String sheetName) {
        int rowCount = 0;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            rowCount = sheet.getPhysicalNumberOfRows();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
