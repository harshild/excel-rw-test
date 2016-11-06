import com.harshild.utility.ExcelHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by geetika on 6/11/16.
 */
public class Test {




    public static void main(String[] args) {
        ExcelHelper a= new ExcelHelper("./../Downloads/BTCI_test_bak.xlsx");

        for (int i = 0; i < 10; i++) {
            System.out.println(a.getExcelSheetData("Test_Data",i,"Emp_Salary"));
        }
    }
}
