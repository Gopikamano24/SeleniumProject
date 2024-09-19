package reqChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_1DeleteProject {

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
		.assertThat().statusCode(201).log().all();
		//capture projname form the response
		String projId	= res.jsonPath().get("projectId");
		System.out.println(projId);

		//API-2 delete project
		given().delete("http://49.249.28.218:8091/project/"+projId)
		.then().log().all();

	}
}
