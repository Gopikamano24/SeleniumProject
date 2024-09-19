package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMthdChainingTest {

	@Test
	public void request() {
		get("https://reqres.in/api/users?page=2").then().log().all();
		
	}
	
	
}
