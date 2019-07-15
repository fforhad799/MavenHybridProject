package webdriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToUseWebdriverManager {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//driver= new FirefoxDriver();
		
		//WebDriverManager.edgedriver().setup();
		//driver=new EdgeDriver();
		
		
		driver.manage().window().maximize();
		
		
	}
	@Test
	public void WebdriverManagerTest() {
		driver.get("https://www.google.com");
	}
	

}
