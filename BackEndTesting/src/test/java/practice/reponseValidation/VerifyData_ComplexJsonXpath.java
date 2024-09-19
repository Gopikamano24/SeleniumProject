
package practice.reponseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_ComplexJsonXpath {

	@Test
	public void sampleTest() {
        Response res= given().get("http://49.249.28.218:8091/projects-paginated");
		
		res.then().log().all();
		
		List<String> list = JsonPath.read(res.asString(),"content[*].projectName");
		for(String data: list) {
			System.out.println(data)
			;
		}
		
		List<String> list1 = JsonPath.read(res.asString(),"content[*].[?(@.projectName=='ABB_71686')].projectId");
		String actProjectID=list1.get(0);
		
		Assert.assertEquals(actProjectID,"NH_PROJ_833" );//here we cant go for rest
//assured assertion bcz we are extracting data from response and then validating
		
		
	}
	
}
