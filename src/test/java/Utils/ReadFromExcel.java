package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {

    private static String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/TestData.xlsx";

    static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream(testDataDir);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static XSSFSheet loginTab=workbook.getSheet("LoginDetails");

   public static String email=loginTab.getRow(1).getCell(0).getStringCellValue();
    public static String password=loginTab.getRow(1).getCell(1).getStringCellValue();
    public static String invalidpassword=loginTab.getRow(2).getCell(1).getStringCellValue();







}
