package com.sample.crud.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPutTest {


	@Test
	public void postDataIntoServer() {
		JSONObject jsonObj=new JSONObject();//to create object for json before adding body using request specification
		jsonObj.put("createdBy", "gopika");
		jsonObj.put("projectName", "abc13");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());//passing the body 
		
		Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_730");
		
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}

}
