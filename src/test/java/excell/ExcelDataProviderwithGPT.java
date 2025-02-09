package excell;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProviderwithGPT {   //нихера не робит

    WebDriver driver;

    public void takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());
        String screenshotPath = "C:\\Projects\\screenshots\\" + testName + "_" + timestamp + ".png";
        try {
            org.apache.commons.io.FileUtils.copyFile(src, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUpTest() {
        System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "test1data")
    public void test1(String username, String password) {
        System.out.println(username + " | " + password);
        driver.get("http://ask-int.portnov.com/#/login");
        // Ваши действия на странице
    }

    @DataProvider(name = "test1data")
    public Object[][] getData() {
        String excelPath = "C:\\Projects\\Selenium\\Java Eclipse\\SeleniumFramework\\excel\\data.xlsx";
        return testData(excelPath, "List1");
    }

    public Object[][] testData(String excelPath, String sheetName) {
        try (Workbook workbook = WorkbookFactory.create(new File(excelPath))) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][colCount];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshot(result.getMethod().getMethodName());
        if (driver != null) driver.quit();
    }
}
