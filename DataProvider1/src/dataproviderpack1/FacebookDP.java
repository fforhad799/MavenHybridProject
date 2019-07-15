package dataproviderpack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookDP {
	//i declare driver globally
	WebDriver driver;
	//I PROVIDE TESTNG ANNOTATION-@Test.2.@BeforeTest.3.@AfterTest.4.@BeforeMethod.5.@AfterMethod.6.@BeforeGroup.7.@AfterGroup.8@BeforeSuite.9.@AfterSuite.10.@Parametarization.11.@Dataprovider.12.@Beforeclass.13.@AfterClass
	
	@BeforeTest 
	
	public void OpenBrowser () {
		System.setProperty("webdriver.chrome.driver", "/Users/mdshalauddin/Desktop/ITTraining/AllDriver/chromedriver");
		driver=new ChromeDriver();
		//I INITIATE WINDOWS
         driver.manage().window().maximize();
         //i declare implicitywait to hold the driver for certain time and driver will wait to get the webelement from the web page.
       //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	@Test(dataProvider="ourwebsite")
	public void facebooksingup(String FN,String LN, String EM, String CM, String Ps,String BM,String Yr, String DB) throws InterruptedException {
	//I NEVEGATE URL
    
    	driver.get("file:///Users/mdshalauddin/Desktop/ITTraining/OurWebSite.html");
        driver.findElement(By.id("NF")).sendKeys(FN);
		
		driver.findElement(By.name("Nname")).sendKeys(LN);
		
		//Xpath using id attribute
		
		driver.findElement(By.xpath("//*[@id=\"EM\"]")).sendKeys(EM);
		
		//Xpath using attribute name
		
		driver.findElement(By.xpath("//*[@id=\"RE\"]")).sendKeys(CM);
		
		//Xpath using by tag name
		
		driver.findElement(By.xpath("//input[5]")).sendKeys(Ps);
		
		Select monthSelect=new Select(driver.findElement(By.id("Mah")));
		monthSelect.selectByVisibleText(BM);
		
		Select yearSelect=new Select(driver.findElement(By.id("Yr")));
		yearSelect.selectByVisibleText(Yr);
		
		Select DaySelect=new Select(driver.findElement(By.id("Dy")));
		DaySelect.selectByVisibleText(DB);
		//driver.findElement(By.id("male")).click();
		//driver.findElement(By.id("female")).click();
		//driver.findElement(By.id("chk1")).click();
		//driver.findElement(By.name("DL")).click();
		
		
    }
    @AfterTest
    public void CloseBrowser() throws InterruptedException {
    	driver.close();
    	Thread.sleep(4000);
    }
    @DataProvider(name="ourwebsite")
    public Object[][] getData(){
    	return new Object[][] {
    		{"forhad", "islam", "forhad@gmail.com", "forhad@gmail.com", "1234","Feb", "2002","2"},
    		{"maksud", "islam", "maksud@gmail.com", "maksud@gmail.com", "756474","Feb", "2002","2"}
    	};
    	}
    

}




