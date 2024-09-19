package com.sample.crud.withBDD.copy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTestForReadTest {

	
	@Test
	public void getDataFromServer() {
		when().get("http://49.249.28.218:8091/project/NH_PROJ_727").then().assertThat().statusCode(200).log().all();
	}
	
}
