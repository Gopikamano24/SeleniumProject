package practice.postRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;


import io.restassured.http.ContentType;

public class PostReq_via_POJOclass {
	public void postDataIntoServer() {
		Random rdm=new Random();
		int ran=rdm.nextInt(2000);
		
		ProjectPOJO pobj=new ProjectPOJO("Abb"+ran,"created","gopika",10);
		
		given().contentType(ContentType.JSON)
		.body(pobj)
		.when().post("http://49.249.28.218:8091/project/NH_PROJ_727")
		.then().assertThat().statusCode(200).log().all();
		
	
	}
}
