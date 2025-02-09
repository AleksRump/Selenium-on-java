package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;                       //это для одного теста
import org.testng.annotations.BeforeMethod;  // для много тестов
import org.testng.annotations.BeforeSuite;   // для много тестов
//import org.testng.annotations.BeforeTest;                      //это для одного теста
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports; // с этим все библиотеки грузит;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject.logINportPO2varios; // импорт PO
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtRepTestNGwithRagh { // тут писать что бы было доступно для всех
	ExtentReports extent;
	ExtentSparkReporter sparkReporte;
	ExtentTest testNORM1; // тут менять название для действий *1*
	logINportPO2varios searchPageObject ;  // создаёт объект класса страницы что бы searchPageObject ссылался на PO

	WebDriver driver;

	@BeforeSuite
	public void setUP() { // функция настройки
		extent = new ExtentReports();
		sparkReporte = new ExtentSparkReporter("ERwithTestNG2tests.html");
		extent.attachReporter(sparkReporte);
		searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO

	}

	@BeforeMethod
	public void setUpTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	}

	@Test // запуск теста
	public void testERtestNG() { // функция теста
		testNORM1 = extent.createTest("ExtRep TestNG Norm 2tests1", "Test to validate login functionality with valid credentials"); // название теста менять пр новом тесте
		// testNORM нужно менять при новом тесте *1*                 // "Test to validate login... это пишется в заголовке отчёта
		
		// Создание объекта Page Object
        logINportPO2varios searchPageObject = new logINportPO2varios(driver);

        // Открытие страницы логина
        driver.get("http://ask-int.portnov.com/#/login");
        testNORM1.pass("Navigated to the login page");

        // Установка данных для логина
        searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
        testNORM1.pass("Entered email");

        searchPageObject.setTextBoxPassword("12345678");
        testNORM1.fail("Entered password FAIL");

        // Нажатие на кнопку "Sign In"
        searchPageObject.clickButtons();
        
        //подождать
        try {                     // Ожидание 2 секунды
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
        
       // Добавление скриншота
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./screenshots/screenshot1.png";
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            testNORM1.pass("Screen created", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            testNORM1.fail("Error created csreen: " + e.getMessage());
        }

//        // Вывод сообщения об успешном завершении теста
//        System.out.println("Tests Completed Successfully");   // это добавлено в aftertest
//        testNORM.info("Test completed successfully");

		testNORM1.log(Status.INFO, "This step shows use of log(status details)");        // это список действий с шагами теста
		testNORM1.info("This step show info(details)");
//		testNORM.fail("details", MediaEntityBuilder.createScreenCaptureFromBase64String("screenshot.png").build());
//		testNORM.addScreenCaptureFromPath("screenshot.png");
		// Dispayed resukts
				System.out.println("Tests Failed with ivalid password");  // происывать и будет писать что тест выполнен в console внизу

	}

	@Test // запуск теста
	public void testERtestNG2() { // функция теста
		testNORM1 = extent.createTest("ExtRep TestNG Norm 2tests", "Test to validate login functionality with invalid credentials"); // название теста менять пр новом тесте
		// testNORM нужно менять при новом тесте *1* // "Test to validate login... это
		// пишется в заголовке отчёта
		
		// Создание объекта Page Object
        logINportPO2varios searchPageObject = new logINportPO2varios(driver);

        // Открытие страницы логина
        driver.get("http://ask-int.portnov.com/#/login");
        testNORM1.pass("Navigated to the login page");

        // Установка данных для логина
        searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
        testNORM1.pass("Entered email");

        searchPageObject.setTextBoxPassword("12345");
        testNORM1.pass("Entered password");

        // Нажатие на кнопку "Sign In"
        searchPageObject.clickButtons();
        
      //подождать
        try {                     // Ожидание 2 секунды
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
        
        // Добавление скриншота
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./screenshots/screenshot2.png";
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            testNORM1.pass("Screen created", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            testNORM1.fail("Error created csreen: " + e.getMessage());
        }

//        // Вывод сообщения об успешном завершении теста
//        System.out.println("Tests Completed Successfully");   // это добавлено в aftertest
//        testNORM.info("Test completed successfully");
		
		testNORM1.log(Status.INFO, "This step shows use of log(status details)");    // это список действий с шагами теста
		testNORM1.info("This step show info(details)");
//		testNORM.pass("details", MediaEntityBuilder.createScreenCaptureFromBase64String("screenshot.png").build());
//		testNORM.addScreenCaptureFromPath("screenshot.png");
		// Dispayed resukts
				System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен в console внизу

	}

	@AfterMethod
	public void tearDownTest() {
	        if (driver != null) {
	            driver.quit();
	            testNORM1.pass("Closed the browser");
	        }
	        
//			driver.close();  // это не работает вместе
//			driver.quit();
																			
	}

	@AfterSuite
	public void tearDown() { // функция завершения
		// Генерация отчета
		extent.flush();
	}

}
