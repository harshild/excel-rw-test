import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by geetika on 6/11/16.
 */
public class Test {

    XSSFWorkbook wb;

    XSSFSheet sheet;

    public Test(String filePath)
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

    public String getExcelSheetData(String sheetName,int row,String colName) {
        sheet= wb.getSheet(sheetName);
        int colIndex = getColumnIndex(sheet,colName);
        return sheet.getRow(row).getCell(colIndex).getRawValue();
    }

    private int getColumnIndex(XSSFSheet sheet, String colName) {
        short lastCellNum = sheet.getRow(0).getLastCellNum();

        for (int i = 0; i < lastCellNum; i++) {
            if(sheet.getRow(0).getCell(i).getStringCellValue().equals(colName))
                return i;
        }

        return 0;
    }

    public static void main(String[] args) {

        Test a= new Test("./../Downloads/BTCI_test_bak.xlsx");

        for (int i = 0; i < 10; i++) {

            System.out.println(a.getExcelSheetData("Test_Data",i,"Emp_Salary"));

        }
    }
}
