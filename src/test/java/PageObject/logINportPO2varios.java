package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logINportPO2varios {
	
	WebDriver driver = null;      // в конструкторе для объявления переменной driver на уровне класса logINportPO2varios, что //  объект будет использоваться для управления браузером во всех методах этого класса.
	
	By textbox_Email = By.xpath("//input[@placeholder='Email *']");               // это списмок объектов
	By textbox_Password = By.xpath("//input[@placeholder='Password *']");
	By button_SignIn = By.xpath("//button//span[contains(text(),'Sign In')]");
	
	public logINportPO2varios (WebDriver driver) {                 // это конструктор , как я понял что бы в тесте писать driver а не WebDriver и java понимал              
		this.driver = driver;                        
	}
	
	public void setTextBoxEmail(String email) {                     // String email что бы вводить текст из тестого примера
		driver.findElement(textbox_Email).sendKeys(email);          // email ссылается на String text, а так же sendKeys это действие
	}	// на каждый объект свой public void
	
	public void setTextBoxPassword(String password) {                      // String password что бы вводить текст из тестого примера
		driver.findElement(textbox_Password).sendKeys(password);          // password ссылается на String text, а так же sendKeys это действие
	}	// на каждый объект свой public void
	
	public void clickButtons() {                                   // тут в скобках не надо ничегго писать так как нет данных для ввода
		driver.findElement(button_SignIn).click();
		//driver.findElement(By.xpath("//button//span[contains(text(),'Sign In')]")).sendKeys(Keys.RETURN);  //так можно нажимамть кнопки Keys.RETURN  типо нажми enter
	}
	
	public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
        driver.quit();
        
        }
    }


