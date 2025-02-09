import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class modulartestExportAfterproject {
	
	static String browser;                          // 1) что бы в setBrowser указаный браузер был доступен для остальных двухниже
	static WebDriver driver;                        // 2) ссылается на setBrowserConfig
	
	public static void main(String[] args) {        // очерёдность выполнения теста
		setBrowser();
		setBrowserConfig();
		runTest();
	}
	
	public static void setBrowser() {
		browser="Opera";                          // 1) что бы в setBrowser указаный браузер был доступен для остальных двухниже
	}                                               // 2) что бы использовать setBrowserConfig
	
	public static void setBrowserConfig() {
		
		if(browser.equalsIgnoreCase("Chrome")) {            //  2) настройки браузера и будет ссылаться сюда из за того что написано в browser="Firefox";
		WebDriverManager.chromedriver().setup();    //  метод драйвера управления браузерами
		driver = new ChromeDriver(); 
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {           //  2) настройки браузера и будет ссылаться сюда из за того что написано в browser="Firefox";
		WebDriverManager.firefoxdriver().setup();   //  метод драйвера управления браузерами
		driver = new FirefoxDriver();
		}
		
		// Internet Explorer
		else if (browser.equalsIgnoreCase("Internet Explorer") || browser.equalsIgnoreCase("IE")) {
		    WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver();
		}

		// Edge (Chromium-based)
		else if (browser.equalsIgnoreCase("Edge") || browser.equalsIgnoreCase("MicrosoftEdge")) {
		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		}

//		// Edge (Legacy) - Если нужен старый EdgeHTML драйвер (редко используется)
//		else if (browser.equalsIgnoreCase("EdgeLegacy")) {
//		    System.setProperty("webdriver.edge.driver", "path/to/legacy/edgedriver");
//		    driver = new EdgeDriver();
//		}
		
//		else if (browser.equalsIgnoreCase("Opera")) {  // хз не робит опера и эксплорер
//		    WebDriverManager.chromedriver().setup(); // Opera использует ChromeDriver
//		    driver = new ChromeDriver(); // Используйте ChromeDriver для Opera
//		}

	}
	
	public static void runTest() {
		driver.get("http://ask-int.portnov.com/#/login");       // пойти на сайт
		driver.close();                                         // закрыть браузер
	}

}
