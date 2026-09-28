package myTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXLSdata {
    public static void main(String[] args) {
        String filePath = "C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\BackendTest2\\\\src\\\\main\\\\resources\\\\testdata\\\\testdata.xlsx";
        try {
            // Load the Excel file
            FileInputStream file = new FileInputStream(new File(filePath));

            // Create a Workbook instance for .xlsx file
            Workbook workbook = new XSSFWorkbook(file);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row and each cell
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unsupported cell type\t");
                            break;
                    }
                }
                
                
                
                System.out.println();
            }

            // Close the file and workbook
            workbook.close();
            file.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import org.apache.poi.EncryptedDocumentException;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ReadXLSdata {
//	public static void main (String[] args ) throws EncryptedDocumentException, IOException {
//		ReadXLSdata read = new ReadXLSdata();
//		read.getdata("Login");
//	}
//	
//	
//	public String[][] getdata(String excelSheetName) throws EncryptedDocumentException, IOException {
//	    File f = new File("C:\\Users\\HP\\eclipse-workspace\\BackendTest2\\src\\main\\resources\\testdata\\testdata.xlsx");
//	    FileInputStream fis = new FileInputStream(f);
//	    Workbook workbook = new XSSFWorkbook(fis);
//	    Sheet sheetName = workbook.getSheet(excelSheetName);
//
//	    int totalrows = sheetName.getLastRowNum(); // Use getLastRowNum to get the total number of rows
//	    System.out.println(totalrows);
//	    Row rowcells = sheetName.getRow(0);
//	    int totalcols = rowcells.getLastCellNum();
//	    System.out.println(totalcols);
//
//	    DataFormatter format = new DataFormatter();
//	    String testdata[][] = new String[totalrows][totalcols];
//	    
//	    for (int i = 1; i <= totalrows; i++) { // Iterate through rows correctly
//	        for (int j = 0; j < totalcols; j++) {
//	            testdata[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
//	            System.out.println(testdata[i - 1][j]); // Corrected the array indexing
//	        }
//	    }
//	    return testdata;
//	}
//}
