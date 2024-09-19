package com.sample.crud.withBDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForPutTest {


	@Test
	public void postDataIntoServer() {
		JSONObject jsonObj=new JSONObject();//to create object for json before adding body using request specification
		jsonObj.put("createdBy", "gopika");
		jsonObj.put("projectName", "abc12");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
	
		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when().put("http://49.249.28.218:8091/addProject")
		.then().assertThat().statusCode(201).log().all();
		
		//Response resp = req.post("http://49.249.28.218:8091/addProject");
		
		
	}

}
