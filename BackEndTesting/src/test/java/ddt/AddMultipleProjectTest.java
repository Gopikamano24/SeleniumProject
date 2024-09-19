package ddt;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class AddMultipleProjectTest {

	@Test(dataProvider="getData")
	public void sampleTest(String pName, String status) {
		
//		String pName="samsung";
//		String status="Created";
		String reqbody="{\r\n"
				+ "  \"createdBy\": \"gopika\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()	
		.contentType(ContentType.JSON)
		.body(reqbody)
		.when().post("http://49.249.28.218:8091/addProject")
		.then().log().all();
	
	}
	
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		
		ExcelUtility eLib=new ExcelUtility();
		int count=eLib.getRowCount("Sheet1");
		Object[][] obj=new Object[count][2];
		
		for(int i=0; i<count; i++) {
			obj[i][0] =eLib.getDataFromExcel("Sheet1", i+1, 0);
			obj[i][1] =eLib.getDataFromExcel("Sheet1", i+1, 1);
		}		
				return obj ;
	}
	
	
	
	
	
	
	
	
	
}
