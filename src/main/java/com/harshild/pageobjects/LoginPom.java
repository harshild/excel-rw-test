package com.harshild.pageobjects;

import com.harshild.Constants;
import com.harshild.utility.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geetika on 6/11/16.
 */
public class LoginPom {
    private final ExcelHelper excelHelper;
    WebDriver driver;
    private int rowNumber;

    public LoginPom(WebDriver driver, ExcelHelper excelHelper)
    {
        this.driver=driver;
        this.excelHelper =excelHelper;

    }


    public void enterUserName(String UserName)
    {

        driver.findElement(By.id("email")).sendKeys(UserName);;
    }

    public void enterPassword(String Password)
    {

        driver.findElement(By.id("pass")).sendKeys(Password);;
    }

    public void clickonSubmitBtn()
    {

        driver.findElement(By.id("u_0_l")).click();

    }


    public void login()
    {

        enterUserName(excelHelper.getExcelSheetData("Test_Data", rowNumber, Constants.USERNAME));
        enterPassword(excelHelper.getExcelSheetData("Test_Data", rowNumber, Constants.PASSWORD));
        clickonSubmitBtn();
    }


    public void selectTestcase(String testCaseName) {
        excelHelper.setSheet("Test_Data");
        rowNumber = excelHelper.getRowIndex(testCaseName);
    }
}
