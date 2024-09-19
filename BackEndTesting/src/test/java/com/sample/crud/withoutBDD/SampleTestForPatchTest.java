package com.sample.crud.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPatchTest {


	@Test
	public void postDataIntoServer() {
		JSONObject jsonObj=new JSONObject();//to create object for json before adding body using request specification
		jsonObj.put("createdBy", "gopika24");
		
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());//passing the body 
		
		Response resp = req.patch("http://49.249.28.218:8091/project/NH_PROJ_730");
		
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}

}
