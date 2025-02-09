package tests;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;

import PageObject.logINportPO2varios;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilitys {
	
	//static InternetExplorerDriver driver;       // для создании возможности (InternetExplorerDriver нужно разблокировать InternetExplorer в винде  )
    //static InternetExplorerOptions options;     // что бы не переключался с IE на Edge
	static EdgeDriver driver;
	static EdgeOptions options;
//	//static EdgeDriverOptions options;;            // для создании возможности (InternetExplorerDriver нужно разблокировать InternetExplorer в винде  )

	public static void main(String[] args) {
		
		options = new EdgeOptions();       // для создании возможности настройки браузера  
		 //options.setCapability("ignoreProtectedModeSettings", true);         // игнорирует безопасность браузера 
		    
		 WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver(options);   // options вписывать что бы использовало от InternetExplorerOptions
	    
	   
	    
	 // Create an instance of the Page Object
	 		logINportPO2varios searchPageObject = new logINportPO2varios(driver);  // создаёт объект класса страницы что бы searchPageObject ссылался на PO
	 		
	 //Navigate to the login page
	 		driver.get("http://ask-int.portnov.com/#/login");
	 		
	 //set valid data
	 		searchPageObject.setTextBoxEmail("teacherBP1@gmail.com");
	 		searchPageObject.setTextBoxPassword("12345");
	 		
	 //click button sin in
	 		searchPageObject.clickButtons();
	 		
	 		driver.close();
	 		driver.quit();
	 		
	 // Dispayed resukts
	 	    System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен

	}

}
