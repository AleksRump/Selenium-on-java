import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findLocators {
    public static void main(String[] args) {
    
    	 WebDriverManager.firefoxdriver().setup();
         WebDriver driver = new FirefoxDriver(); 
         //driver.manage().window().maximize();  //откроет браузер на весь экран
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         
         driver.get("http://ask-int.portnov.com/#/login");
         
      // Log in to the application
         WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email *']"));   // driver.findElement-для указания лемента (By.id("писать id элемента"))
         emailField.click();   //действие
         emailField.sendKeys("teacherBP1@gmail.com"); // вввести данные
         
         List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));   //этот блок покажет сколько input элементов на странице, так же можно посчитать другие элементы
         int count = listOfInputElements.size();
         System.out.println("Count of Iput elements : "+count);                 // syso покажет этуфункцию
         
         driver.close();  
    
    }
}
