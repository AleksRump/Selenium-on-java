package excell;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.logINportPO2varios;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {    // так покажет все данные из файла data.xlsx
			
//	public static void main(String[] args) {                                                                // это без testNG
//		String excelPath = "C:\\Projects\\Selenium\\Java Eclipse\\SeleniumFramework\\excel\\data.xlsx";
//		testData(excelPath, "List1");
//	}
//	
	
	
	WebDriver driver=null;
	
	// Метод для создания скриншотов
    public void takeScreenshot(String testName) {                                     // для создания скрина
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

     // Уникальный идентификатор (дата и время)
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());


        // Директория для скриншотов
        String folderPath = "C:\\Projects\\Selenium\\Java Eclipse\\SeleniumFramework\\screenshots\\\\" + testName;
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs(); // Создаём папку, если она не существует
        }

        // Полный путь к файлу скриншота
        String screenshotPath = folderPath + "\\" + testName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }                                                                             // для создания скрина
		

	@BeforeMethod
	public void setUpTest() { 

		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); 
		
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username+" | "+password);
		
		logINportPO2varios searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO
		
		// Navigate to the login page
		driver.get("http://ask-int.portnov.com/#/login");

		// set valid data
		searchPageObject.setTextBoxEmail(username);
		searchPageObject.setTextBoxPassword(password);

		// click button sin in
		searchPageObject.clickButtons();
		Thread.sleep(1000);
		
		driver.close();
		
	}
	
	@DataProvider(name = "test1data")        // это с testNG
	public Object[][] getData() {
		String excelPath = "C:\\Projects\\Selenium\\Java Eclipse\\SeleniumFramework\\excel\\data.xlsx";
		Object data[][] = testData(excelPath, "List1");
		return data;
	}
	
	
	public Object [][] testData(String excelPath, String sheetName) {
		
	excelRowCount excel = new excelRowCount(excelPath, sheetName);
	
	int rowCount = excelRowCount.getRowCount();  //int цело число  // int rowCount = excel.getRowCount();  это статический вариант и считается плохой практикой
	int colCount = excelRowCount.getColCount();  //вызываются напрямую через имя класса (excelRowCount)
	
	Object data[][] = new Object [rowCount-1][colCount];
	
	for(int i=1; i<rowCount; i++) {     //int i=1 это строка, не с 0 потому что 0 это заголовок с названием столбцов  // Пропускаем заголовок (i = 1)
		for(int j=0; j<colCount; j++) {       // int j=0 этостолбец а таак как данные в таблице начинаются с первого столбца по этому пишем 0
			
			String cellData = excelRowCount.getCellDataString(i, j);
			//System.out.print(cellData+" | ");
			data[i-1][j] = cellData;                       // Добавляем данные в массив
			
		}
		
	}
	return data;
	}
	
//	@AfterMethod                                            // и без него работает хз на кой это
//    public void tearDown(ITestResult result) {
//        // Получаем имя текущего теста
//        String testName = result.getMethod().getMethodName();
//
//        // Делаем скриншот независимо от результата теста
//        takeScreenshot(testName);
//
//        // Завершаем тест
//        if (driver != null) {
//            driver.quit();
//        }
//        System.out.println("Finish: " + testName);
//    }
}

