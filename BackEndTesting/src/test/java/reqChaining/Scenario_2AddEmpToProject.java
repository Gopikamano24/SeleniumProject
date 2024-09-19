package reqChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_2AddEmpToProject {

	@Test
	public void postDataIntoServer() {
		Random rdm=new Random();
		int ran=rdm.nextInt(2000);

		//API-1 add a project inside the server
		ProjectPOJO pobj=new ProjectPOJO("bsnl_"+ran,"created","gopika",0);

		Response res=given().contentType(ContentType.JSON)
				.body(pobj)
				.when().post("http://49.249.28.218:8091/addProject");
		res.then()
		.assertThat().statusCode(201)
		.and().assertThat().body("msg",Matchers.equalTo("Successfully Added"))
		.log().all();
		
		//capture projname form the response
		String projName	= res.jsonPath().get("projectName");
		System.out.println(projName);

		//API-2 add Emp to project
//String designation, String dob, String email, String empName, double experience, String mobileNo,
		//String project, String role, String username
     
		EmployeePOJO empobj=new EmployeePOJO("Tester", "24/12/1999", "gopika@gmail.com", "user_"+ran, 4, "9897969594", projName, "ROLE_EMPLOYEE", "user_"+ran);
		given().contentType(ContentType.JSON)
		.body(empobj)
		.when().post("http://49.249.28.218:8091/employees")
		.then().assertThat().statusCode(201).log().all();
		
		
		
	}
}
