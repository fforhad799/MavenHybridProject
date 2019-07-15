package operation;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UIOperation extends AbstractClass{
	
	public UIOperation(WebDriver driver) {
		AbstractClass.driver=driver;
		
	}
	
	public void KeyWordPerforme(Properties p, String KeyWord, String ObjectName, String ObjectType, String Data) throws Exception {
		
		switch(KeyWord.toUpperCase()) {
		case "GOTOURL":
			driver.get(p.getProperty(Data));
			break;
		case "SENDKEYS":
			driver.findElement(this.getObject(p, ObjectName, ObjectType)).sendKeys(Data);
			break;
		case "CLICK":
			driver.findElement(this.getObject(p, ObjectName, ObjectType)).click();
			break;
		case "SELECT":
			Select dropdown=new Select(driver.findElement(this.getObject(p, ObjectName, ObjectType)));
			dropdown.selectByVisibleText(Data);
			break;
		case "CLOSE":
			driver.close();
			break;
		case "QUIT":
			driver.quit();
			break;
		case "THREAD":
			Thread.sleep(3000);
			break;
		case "SCREENSHOT":
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("/Users/mdshalauddin/eclipse-workspace/MavenHybridFrameWork/Screenshot/facebook.jpg"));
			break;
		case "DOUBLECLICK":
			WebElement dbc=driver.findElement(this.getObject(p, ObjectName, ObjectType));
			Actions act=new Actions(driver);
			act.doubleClick(dbc).build().perform();
			break;
			
		case "GETTITLE":
			String title=driver.getTitle();
			System.out.println("Title is : "+title);
			break;
		case "CURRENTURL":
			String url=driver.getCurrentUrl();
			System.out.println("Current url is : "+url);
			break;
		case "SUBMENUHANDLING":
			WebElement element=driver.findElement(this.getObject(p, ObjectName, ObjectType));
			Actions act1=new Actions(driver);
			act1.moveToElement(element).build().perform();
			break;
		case "ALERTHANDLING":
			Alert alt=driver.switchTo().alert();
			alt.accept();
			//alt.dismiss();
			System.out.println("Alert Text is : "+alt.getText());
			break;
		case "LINKCOUNTNG":
			List<WebElement>link=driver.findElements(By.tagName("a"));
			System.out.println("Total links are: "+link.size());
			System.out.println("All Links are :");
			for(int i=0; i<link.size(); i++) {
				System.out.println(i+". "+link.get(i).getText()+"------"+link.get(i).getAttribute("href"));
			}
			break;
			
		}
		
		
	}
	public By getObject(Properties p,  String ObjectName, String ObjectType) throws Exception{
		
		if(ObjectType.equalsIgnoreCase("ID")) {
			return By.id(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("NAME")) {
			return By.name(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("CSSSELECTOR")) {
			return By.cssSelector(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("TAGNAME")) {
			return By.tagName(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("LINKTEXT")) {
			return By.linkText(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("PARTIALLINKTEXT")) {
			return By.partialLinkText(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(p.getProperty(ObjectName));
		}
		
		else {
			throw new Exception("Wrong object Type");
		}
	}
	

}
