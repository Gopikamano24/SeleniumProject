package com.sample.crud.withBDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForPatchTest {


	@Test
	public void postDataIntoServer() {
		JSONObject jsonObj=new JSONObject();//to create object for json before adding body using request specification
		jsonObj.put("createdBy", "gopika24");
			
		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when().patch("http://49.249.28.218:8091/project/NH_PROJ_727").then().assertThat().log().all();
		
		//Response resp = req.post("http://49.249.28.218:8091/addProject");
		
		
	}

}
