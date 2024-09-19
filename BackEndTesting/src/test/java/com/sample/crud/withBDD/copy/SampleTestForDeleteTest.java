package com.sample.crud.withBDD.copy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {

	
	@Test
	public void getDataFromServer() {
		when().delete("http://49.249.28.218:8091/project/NH_PROJ_727").then().assertThat().statusCode(204).log().all();
		//Response resp=RestAssured.get("http://49.249.28.218:8091/projects/NH_PROJ_727");
		
	}
	
}
