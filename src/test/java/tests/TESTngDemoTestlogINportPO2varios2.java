package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.logINportPO2varios;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TESTngDemoTestlogINportPO2varios2 {
	private WebDriver driver = null;
	

	
	@BeforeMethod   // запуск много раз браузер  //// c этим можно создавать много @Test
	public void setUpTest() {                      // это функция настройка теста
		WebDriverManager.firefoxdriver().setup();  // **2** ставим сюда
		driver = new FirefoxDriver();
		
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
