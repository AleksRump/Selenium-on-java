package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPortPO {
	
	private static WebElement element = null;  // теперь элемент статичный и приватный для этой группы
	
	public static WebElement textbox_emaik(WebDriver driver) {  // создал для одного элемента и так для каждого //(WebDriver driver) это что бы не писать static WebDriver driver
		
		element = driver.findElement(By.xpath("//input[@placeholder='Email *']"));
		return element;
	}
	
public static WebElement textbox_password(WebDriver driver) {  // создал для одного элемента и так для каждого //(WebDriver driver) это что бы не писать static WebDriver driver
		
		element = driver.findElement(By.xpath("//input[@placeholder='Password *']"));
		return element;
	}

public static WebElement button_login(WebDriver driver) {  // создал для одного элемента и так для каждого //(WebDriver driver) это что бы не писать static WebDriver driver
	
	element = driver.findElement(By.xpath("//button//span[contains(text(),'Sign In')]"));
	return element;
}

}
