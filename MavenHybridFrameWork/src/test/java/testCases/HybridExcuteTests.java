package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import operation.AbstractClass;
import operation.ReadObject;
import operation.UIOperation;


public class HybridExcuteTests extends AbstractClass{
	
	
	@Test(dataProvider="HybridTestData")
	public void AplicationUnderTest(String TestCaseID, String TestCaseName, String KeyWord, String ObjectName, String ObjectType, String Data) throws Exception {
		
		 
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);   
		operation.KeyWordPerforme(allObjects, KeyWord, ObjectName, ObjectType, Data);
		
		
	}
	
	@DataProvider(name="HybridTestData")
	public Object[][]  getDataFromDataProvider() throws IOException{
		
		Object[][] object=null;
		
		File f=new File("/Users/mdshalauddin/eclipse-workspace/MavenHybridFrameWork/src/test/resources/TestData/TestData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		
		Sheet ws=wb.getSheet("Data1");
		
		int rowCount=ws.getLastRowNum()-ws.getFirstRowNum();
		int colCount=6;
		
		object=new Object[rowCount][colCount];
		for(int i=0; i<rowCount; i++) {
			Row row=ws.getRow(i+1);
			for(int j=0; j<row.getLastCellNum(); j++) {
				object[i][j]=row.getCell(j).toString();
			}
			
		}
		return object;
	}
	

}
