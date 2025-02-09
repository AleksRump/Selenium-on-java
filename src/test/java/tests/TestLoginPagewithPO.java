package tests;

//import org.openqa.selenium.By;       // почему то после завершения эти становятся не нужными
//import org.openqa.selenium.Keys;     // почему то после завершения эти становятся не нужными
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.LoginPortPO;         // так импортировать из PO для теста
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginPagewithPO {
	
	private static WebDriver driver = null;  // это не понял на кой
	
	public static void main(String[] args) {
	SignIn();   // 1* функция которую вызываю, если не написать тут то тест не запуститься

}

public static void SignIn(){  //1* функция которую вызываю, если не написать тут то тест не запуститься
	
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	
	// Navigate to the login page
    driver.get("http://ask-int.portnov.com/#/login");

    // Log in to the application
    LoginPortPO.textbox_emaik(driver).sendKeys("teacherBP1@gmail.com");  //каждый разчто бы искать объект в PO нужно писатьLoginPortPO
    LoginPortPO.textbox_password(driver).sendKeys("12345");
    
    // Click button login
    LoginPortPO.button_login(driver).click(); //.sendKeys(Keys.RETURN); на кнопке не работает
    
    //Close browser
    driver.quit();
    // Dispayed resukts
    System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
    
}

}



