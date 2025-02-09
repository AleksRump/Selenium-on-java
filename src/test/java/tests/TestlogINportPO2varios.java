package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.logINportPO2varios;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestlogINportPO2varios {
	private static WebDriver driver = null;
	
//	private static Assertion assertion = new Assertion();   // для утверждений  нужно    *****// утверждения пока не понял********
	
	

	public static void main(String[] args) {
		
		testlogIN();                             // *1* *****вот это ******  // // функция которую вызываю, если не написать тут то тест не запуститься
		testlogIN2();                            

	}
	
	public static void testlogIN() {             // *1* ******* из этого *******  //
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		// Create an instance of the Page Object
		logINportPO2varios searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO
		
		//Navigate to the login page
		driver.get("http://ask-int.portnov.com/#/login");
		
		//set valid data
		searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
		searchPageObject.setTextBoxPassword("12345");
		
		//click button sin in
		searchPageObject.clickButtons();
		
//		// Update with the correct URL
//		String expectedUrl = "http://ask-int.portnov.com/#/home";                                                   // перешол на другую страницу
//		assertion.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to the expected page PASS.");       // утверждение верное
//	    
//	    // Example 2: Check if a specific element is present on the next page                                    // утверждения пока не понял
//	    boolean isElementDisplayed = driver.findElement(By.className("icon ng-star-inserted")).isDisplayed();
//	    assertion.assertTrue(isElementDisplayed, "The expected element was FOUND on the page.");
		
		driver.close();
		
		// Dispayed resukts
	    System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
		
	}
	
	public static void testlogIN2() {             // *1* ******* из этого *******  //
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		// Create an instance of the Page Object
		logINportPO2varios searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO
		
		//Navigate to the login page
		driver.get("http://ask-int.portnov.com/#/login");
		
		//set invalid data passwod
		searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
		searchPageObject.setTextBoxPassword("123456");
		
		//click button sin in
		searchPageObject.clickButtons();
		
//		// Update with the correct URL
//		String expectedUrl = "http://ask-int.portnov.com/#/home";                                       // перешол на другую страницу
//		assertion.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to the expected page FAILED."); // утверждение не верное
//			    
//		// Example 2: Check if a specific element is present on the next page
//		boolean isElementDisplayed = driver.findElement(By.className("icon ng-star-inserted")).isDisplayed();
//		//Assertion assertion = new Assertion();
//		assertion.assertTrue(isElementDisplayed, "The expected element was NOY FOUND on the page.");               //// утверждения пока не понял
		
//		try {                          
//			Thread.sleep(1000);               // Ожидание 1 секунды (не знаю почему он требует запихать его в try/catch)
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
		
		driver.close();
		
		// Dispayed resukts
	    System.out.println("Tests Completed Succesfuly with ivalid data");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
		
	}

}
