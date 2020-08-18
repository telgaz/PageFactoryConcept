package basePage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("There is no browser instance "+ browser);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("/Users/tugbaelgaz/eclipse-workspace/Pagefactory/src/main/java/config/config.properties");
			prop.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Some exceptions occured while quitting browser");
		}
	}
}
