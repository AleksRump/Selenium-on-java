package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class first {

	public static void main(String[] args) {
		
		loginpage();   // функция которую вызываю, если не написать тут то тест не запуститься

	}
	
	public static void loginpage(){
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		// Navigate to the login page
        driver.get("http://ask-int.portnov.com/#/login");

        // Log in to the application
        driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("teacherBP1@gmail.com");   // driver.findElement-для указания лемента (By.id("писать id элемента"))
        //emailField.click();   //действие
        //emailField.sendKeys("teacherBP1@gmail.com"); // вввести данные

        driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("12345"); // вот так переделан код теста вместо 3 строк 1
//        passwordField.click();
//        passwordField.sendKeys("12345"); // ваш пароль

        driver.findElement(By.xpath("//button//span[contains(text(),'Sign In')]")).click();
        //signInButton.click();
        //driver.findElement(By.xpath("//button//span[contains(text(),'Sign In')]")).sendKeys(Keys.RETURN);  //так можно нажимамть кнопки Keys.RETURN  типо нажми enter
        
        driver.quit();
        
        System.out.println("Tests Completed Succesfuly");  // происывать и будет писать что тест выполнен, выполнены все шаги значит выполнен
		
	}

}
