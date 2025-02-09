package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;   //почему то эта не загрузилась автоматом
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import PageObject.LoginPortPO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	private static WebDriver driver = null;
	
	// Создание статического объекта ExtentReports, чтобы он использовался для всех тестов
    static ExtentReports extent;         // как понял это что бы отчёты сохранялись в одном файле
    static ExtentSparkReporter spark;

    // Метод для настройки отчета (выполняется один раз)
    static {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("ExtentSparkReport.html");
       
        extent.attachReporter(spark);

    }
	

	public static void main(String[] args) { 
		 // Создание теста в отчете
        ExtentTest firstTest1234 = extent.createTest("MyFirstTest with Extent Report11222333444"); // при новом тесте и создании отчёта нужно менять ИМЯ firstTest и ("MyFirstTest with Etern Report")
				
		 WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        
	     // Navigate to the login page
	        driver.get("http://ask-int.portnov.com/#/login");
	        firstTest1234.pass("URL +");                           // firstTest так же меняй / меняй pass на fail и будет провален
	        
	        // Log in to the application
	        driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("teacherBP1@gmail.com");   // driver.findElement-для указания лемента (By.id("писать id элемента"))
	        firstTest1234.pass("Email +");
	        
	        driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("12345"); // вот так переделан код теста вместо 3 строк 1
	        firstTest1234.pass("Password +"); 
	        
	        driver.findElement(By.xpath("//button//span[contains(text(),'Sign In')]")).click();
	        firstTest1234.pass("Button click -");

	        driver.close();
	        //driver.quit();
	        firstTest1234.pass("Browser closed +");
	        
	        firstTest1234.info("test comlited +");
	        
	        System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
			
	        
	     // Генерация отчета   
		extent.flush();


	}

}
