
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;  // с этим все библиотеки грузит
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import PageObject.logINportPO2varios;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsWithTestNG {  
    
	private WebDriver driver = null;
	private static ExtentReports extent;  // Сделайте ExtentReports статическим, чтобы отчёты сохранялись в одном файле
    private static ExtentSparkReporter sparkReporter;
    private ExtentTest test12;             // тут менять название для действий

 // Инициализация ExtentReports один раз перед всеми тестами
    @BeforeClass                    ////ExtentReports и ExtentSparkReporter в метод @BeforeClass, чтобы они инициализировались один раз для всех тестов.
    public void setUpReport() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("ERwithTestNG.html");

        extent.attachReporter(sparkReporter);

    }
    
    @BeforeMethod             // c этим можно создавать много @Test
    public void setUpTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void testlogIN() {
    	
    	// Создание теста в Extent Reports
        test12 = extent.createTest("Extent Report TestNG11222", "Test to validate login functionality with valid credentials");  // название теста менять пр новом тесте
                                                                // "Test to validate login... это пишется в заголовке отчёта
        // Создание объекта Page Object
        logINportPO2varios searchPageObject = new logINportPO2varios(driver);

        // Открытие страницы логина
        driver.get("http://ask-int.portnov.com/#/login");
        test12.pass("Navigated to the login page");

        // Установка данных для логина
        searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
        test12.pass("Entered email");

        searchPageObject.setTextBoxPassword("12345");
        test12.pass("Entered password");

        // Нажатие на кнопку "Sign In"
        searchPageObject.clickButtons();
        test12.fail("Clicked on the Sign In button");

        // Вывод сообщения об успешном завершении теста
        System.out.println("Tests Completed Successfully");
        test12.info("Test completed successfully");
    }

    @AfterMethod
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
            test12.fail("Closed the browser");
        }
        // Генерация отчета
        extent.flush();
    }
}
