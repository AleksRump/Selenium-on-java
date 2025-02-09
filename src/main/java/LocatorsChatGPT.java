import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsChatGPT {
	public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(); 
        //driver.manage().window().maximize();  //откроет браузер на весь экран
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Navigate to the login page
            driver.get("http://ask-int.portnov.com/#/login");

            // Log in to the application
            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email *']"));   // driver.findElement-для указания лемента (By.id("писать id элемента"))
            emailField.click();   //действие
            emailField.sendKeys("teacherBP1@gmail.com"); // вввести данные

            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password *']"));
            passwordField.click();
            passwordField.sendKeys("12345"); // ваш пароль

            WebElement signInButton = driver.findElement(By.xpath("//button//span[contains(text(),'Sign In')]"));
            signInButton.click();

            // Navigate to "Quizzes"
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(text(),'Quizzes')]"))).click();

            // Create New Quiz
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[contains(text(),'Create New Quiz')]"))).click();
         // Ожидание загрузки страницы
            try {                                         // что бы ожидание работало нужно его заключать в try/cathc
                Thread.sleep(3000); // Ожидание 3 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement quizTitle = driver.findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']"));
            quizTitle.click();
            quizTitle.sendKeys("abracadabra"); // заголовок квиза

            // Add First Question
            driver.findElement(By.xpath("//button//span//mat-icon[contains(text(),'add_circle')]")).click();
            driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-2']")).click();
            WebElement firstQuestion = driver.findElement(By.xpath("//textarea[@placeholder='Question *']"));
            firstQuestion.click();
            firstQuestion.sendKeys("alalalal"); // первый вопрос

            // Save the quiz
            driver.findElement(By.xpath("//button//span[contains(text(),'Save')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'List of Quizzes')]"))); // ожидание списка квизов

            // Verify that the quiz is in the list of quizzes
            WebElement quizInList = driver.findElement(By.xpath("//mat-panel-title[contains(text(),'abracadabra')]"));
            wait.until(ExpectedConditions.visibilityOf(quizInList));
            quizInList.click();

            // Delete the quiz
            driver.findElement(By.xpath("//mat-panel-title[contains(text(),'abracadabra')]/../../..//button[@class='mat-raised-button mat-warn']")).click();
            driver.findElement(By.xpath("//div[@class='mat-dialog-actions']//span[contains(text(),'Delete')]")).click();
            try {
                Thread.sleep(1000); // Ожидание 3 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/ac-root[1]/mat-sidenav-container[1]/mat-sidenav[1]/ac-side-menu[1]/mat-list[1]/mat-list-item[1]/div[1]"))).click();
            try {
                Thread.sleep(1000); // Ожидание 3 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//button//span[contains(text(),'Log Out')]")).click();
            try {                                              // что бы ожидание работало нужно его заключать в try/cathc
                Thread.sleep(3000); // Ожидание 3 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));   //этот блок покажет сколько input элементов на странице, так же можно посчитать другие элементы
            int count = listOfInputElements.size();
            System.out.println("Count of Iput elements : "+count);                 // syso покажет этуфункцию
            

        } finally {
            driver.quit();
        }
    }
}
