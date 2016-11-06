package com.harshild.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by geetika on 6/11/16.
 */
public class ExcelHelper {
    XSSFWorkbook wb;

    XSSFSheet sheet;

    public ExcelHelper(String filePath)
    {

        File file= new File(filePath);


        try {
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Exception is:::"+e.getMessage());
        }
    }

    public void setSheet(String sheetName) {
        sheet= wb.getSheet(sheetName);
    }

    public String getExcelSheetData(String sheetName,int row,String colName) {
        sheet= wb.getSheet(sheetName);
        int colIndex = getColumnIndex(colName);
        return sheet.getRow(row).getCell(colIndex).getStringCellValue() ;
    }

    public int getColumnIndex( String colName) {

        short lastCellNum = sheet.getRow(0).getLastCellNum();

        for (int i = 0; i < lastCellNum; i++) {
            if(sheet.getRow(0).getCell(i).getStringCellValue().equals(colName))
                return i;
        }

        return 0;
    }

    public int getRowIndex( String rowName) {
        int lastCellNum = sheet.getLastRowNum();

        for (int i = 0; i < lastCellNum; i++) {
            if(sheet.getRow(i).getCell(0).getStringCellValue().equals(rowName))
                return i;
        }

        return 0;
    }

}
