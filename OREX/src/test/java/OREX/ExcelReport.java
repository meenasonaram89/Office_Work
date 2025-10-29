package OREX;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReport {

    private Workbook workbook;
    private Sheet sheet;
    private String folderPath;
    private String filePath;
    private int currentRow; // Track row number

    public ExcelReport() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Automation Report");
        currentRow = 0;

        // Header row
        Row header = sheet.createRow(currentRow++);
        String[] headers = {"Test Module", "Test Step", "Status", "Remarks"};
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

        // Folder & file path
        folderPath = "C:\\Users\\IG07\\Desktop\\AutomationReportGenerated";
        filePath = folderPath + "\\AutomationReport.xlsx";

        // Create folder if it doesn't exist
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Add a test result immediately to the sheet
    public void addTestResult(String module, String step, String status, String remarks) {
        Row row = sheet.createRow(currentRow++);
        row.createCell(0).setCellValue(module);
        row.createCell(1).setCellValue(step);
        row.createCell(2).setCellValue(status);
        row.createCell(3).setCellValue(remarks);
    }

    // Generate/write Excel file
    public void generateReport() {
        // Auto-size columns
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Excel report generated successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Test main
    public static void main(String[] args) {
        ExcelReport report = new ExcelReport();
        report.addTestResult("Login Module", "Enter username", "PASS", "Username entered successfully");
        report.addTestResult("Login Module", "Enter password", "FAIL", "Password missing");
        report.addTestResult("Dashboard Module", "Click settings", "PASS", "Settings opened");
        report.generateReport();
    }
}
