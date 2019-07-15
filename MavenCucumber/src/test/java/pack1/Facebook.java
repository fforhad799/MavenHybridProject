package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Facebook {
	
	
WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/mdshalauddin/Desktop/ITTraining/AllDriver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	 @Test(dataProvider="facebookData")
	public void facebookText(String firstname,String lastname,String reg_email,String reg_passwd,String regemail,String Month,String Day,String Year,String Sex) { 
		 
		 driver.get("https://www.facebook.com/");
		 
		 driver.findElement(By.xpath("//*[@id='u_0_c']")).sendKeys(firstname);
		 driver.findElement(By.xpath("//*[@id='u_0_e']")).sendKeys(lastname);
		 driver.findElement(By.xpath("//*[@id='u_0_h']")).sendKeys(reg_email);
		 driver.findElement(By.xpath("//*[@id='u_0_o']")).sendKeys(reg_passwd);
		 driver.findElement(By.xpath("//*[@id='u_0_k']")).sendKeys(regemail);
		
		 
		 Select MonthSelect=new Select(driver.findElement(By.id("month")));
		 MonthSelect.selectByVisibleText(Month);
		 
		 Select DaySelect=new Select(driver.findElement(By.id("day")));
		 DaySelect.selectByVisibleText(Day);
		 
		 Select yearSelect=new Select(driver.findElement(By.id("year")));
		 yearSelect.selectByVisibleText(Year);
		  
		 if(Sex.equalsIgnoreCase("Male")) {
			 
			 driver.findElement(By.id("u_0_t")).click();
			 	
			}
		 else if(Sex.equalsIgnoreCase("Female")){
			 driver.findElement(By.id("u_0_9")).click();
		 }
		 else {
			 System.out.println("worng object name");
		 }
		 }
		 
	 
	 @AfterTest
	 public void CloseBrowser() throws InterruptedException {
		 Thread.sleep(4000);
		 driver.close();
	 }
	 @DataProvider(name="facebookData")
	 public Object[][] getData(){
		 
		 return new Object[][] {
			 {"forhad", "uddin","forhad@yahoo.com","1nnbc","uddinsu23@yahoo.com","Feb","2","2000","Male"}, 
			 {"SUMU", "parvij","forhad@yahoo.com","1nnbck","uddinsu23@yahoo.com","Jan","6","2001","Female"},
			 {"forhad", "uddin","forhad@yahoo.com","1nnbc","uddinsu23@yahoo.com","Feb","2","2000","Male"}, 
			 {"Aleya", "parvij","forhad@yahoo.com","1nnbck","uddinsu23@yahoo.com","Jan","6","2001","Female"}
			 
			 
			 
			 
		 };  
		 
	 }
		 
}
	
	


