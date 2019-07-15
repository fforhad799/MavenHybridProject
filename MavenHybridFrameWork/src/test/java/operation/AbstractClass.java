package operation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class AbstractClass {
	
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "/Users/mdshalauddin/eclipse-workspace/MavenHybridFrameWork/src/test/resources/drivers/chromedriver");
		//driver=new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/mdshalauddin/eclipse-workspace/MavenHybridFrameWork/src/test/resources/drivers/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void failed(String testName)  {
    	File srcf=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(srcf, new File("/Users/mdshalauddin/eclipse-workspace/MavenHybridFrameWork/Screenshot/"+testName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    }
}
