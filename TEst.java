import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;


public class TEst {
    String appURL = "https://www.childrensplace.com/us/search";
    Action call;
    WebDriver driver;

    @BeforeClass
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ramesh/Desktop/SeleniumTesting/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(appURL);
    }

    @Test(priority = 1,dataProvider = "Authentication")
    public void verfiySearchTestBox(Object [] values) throws InterruptedException {
        String value = (String) values[0];
        call = new Action(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        call.filledSearchTextBox(value);
        System.out.println(value);

    }

    @DataProvider(name = "Authentication")
    public Object[][] Authentication() throws Exception{

        // Setting up the Test Data Excel file
        String sTestCaseName;

        ExcelUtils.setExcelFile("/Users/Ramesh/Desktop/SeleniumTesting/valuefile.xlsx","Sheet1");

        sTestCaseName = this.toString();

        // From above method we get long test case name including package and class name etc.

        // The below method will refine your test case name, exactly the name use have used

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

        // Fetching the Test Case row number from the Test Data Sheet

        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

        int iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

        Object[][] testObjArray = ExcelUtils.getTableArray("/Users/Ramesh/Desktop/SeleniumTesting/valuefile.xlsx","Sheet1",iTestCaseRow);

        return (testObjArray);

    }
}

