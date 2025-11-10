package utilities;


import java.io.FileInputStream;                                                                                                                             
import java.io.IOException;                                                                                                                                 
import org.apache.poi.ss.usermodel.*;                                                                                                                       
import org.apache.poi.xssf.usermodel.XSSFWorkbook;                                                                                                          
                                                                                                                                                            
public class ExcelReader {                                                                                                                                  
	public static String getCellValue(String filePath, String sheetName, int row, int col) {                                                                
        String value = "";                                                                                                                                  
        try (FileInputStream fis = new FileInputStream(filePath);                                                                                           
             Workbook workbook = new XSSFWorkbook(fis)) {                                                                                                   
                                                                                                                                                            
            Sheet sheet = workbook.getSheet(sheetName);                                                                                                     
            Row dataRow = sheet.getRow(row);                                                                                                                
            Cell cell = dataRow.getCell(col);                                                                                                               
                                                                                                                                                            
            value = cell.getStringCellValue();                                                                                                              
                                                                                                                                                            
        } catch (IOException e) {                                                                                                                           
            e.printStackTrace();                                                                                                                            
        }                                                                                                                                                   
        return value;                                                                                                                                       
    }

	/*
	 * public static int getLastRowIndex(String filePath, String sheet) { // TODO
	 * Auto-generated method stub return 0; }
	 */                                                                                                                                     
	                                                                                                                                                        
                                                                                                                                                            
}                                                                                                                                                           
                                                                                                                                                            