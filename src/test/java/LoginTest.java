import com.harshild.pageobjects.LoginPom;
import com.harshild.utility.ExcelHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by geetika on 6/11/16.
 */
public class LoginTest {
    WebDriver driver;
    LoginPom login;
    ExcelHelper excelHelper;




    @Before
    public void setup() {
        driver= new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        excelHelper = new ExcelHelper("./../Downloads/BTCI_test_bak.xlsx");
        login=new LoginPom(driver,excelHelper);
    }

    @org.junit.Test

    public void verifyLogin() {
        login.selectTestcase("TC_0005");
        login.login();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
