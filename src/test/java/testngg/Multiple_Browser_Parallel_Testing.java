package testngg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.logINportPO2varios;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Browser_Parallel_Testing {
	
private WebDriver driver = null;
	

	@Parameters("browserName")
	@BeforeMethod   // запуск много раз браузер  //// c этим можно создавать много @Test
	public void setUpTest(String browserName) {                      // это функция настройка теста
		System.out.println("Browser name id"+browserName);
		System.out.println("Thread id :"+ Thread.currentThread().getId());   // покажет номер потока с которым запускается тест
		
		if(browserName.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup();  // **2** ставим сюда
		driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();    //  метод драйвера управления браузерами
			driver = new ChromeDriver(); 
			}
		
//		else if(browserName.equalsIgnoreCase("Opera")) {        // поддержка тестов на opera прекращена в v4 selenium
//			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.opera.driver", "C:\\Projects\\Selenium\\Java Eclipse\\SeleniumFramework\\operadriver_win64\\operadriver.exe");
//	        ChromeOptions operaOptions = new ChromeOptions();
//	        operaOptions.setBinary("C:\\Users\\shtil\\AppData\\Local\\Programs\\Opera\\opera.exe");
//	        driver = new ChromeDriver(operaOptions);
//			}
		
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
			}
		
	}
	@Test   // так прописываем порядок выполнения теста
	public void testlogIN() {             // *1* ******* из этого *******  //    //это функция сам тест 1
		
		// Create an instance of the Page Object
		logINportPO2varios searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO
		
		//Navigate to the login page
		driver.get("http://ask-int.portnov.com/#/login");
		
		//set valid data
		searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
		searchPageObject.setTextBoxPassword("12345");
		
		//click button sin in
		searchPageObject.clickButtons();
		
		// Dispayed resukts
	    System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
		
	}
	
	@Test   // так прописываем порядок выполнения теста
	public void testlogIN2() {             // *1* ******* из этого *******  //    //это функция сам тест 1
		
		// Create an instance of the Page Object
		logINportPO2varios searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO
		
		//Navigate to the login page
		driver.get("http://ask-int.portnov.com/#/login");
		
		//set valid data
		searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
		searchPageObject.setTextBoxPassword("123456");
		
		//click button sin in
		searchPageObject.clickButtons();
		
		// Dispayed resukts
	    System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
		
	}

	@AfterMethod   // так прописываем порядок выполнения теста
	public void tearDownTest() {   // это функция завершения теста
		if (driver != null) {
            driver.quit();         // так писать что бы после всего выполнить quit
        }
		
	}

}

