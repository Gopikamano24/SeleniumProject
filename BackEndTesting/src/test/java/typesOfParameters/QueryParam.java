package typesOfParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class QueryParam {

	
	@Test
	public void queryParameter() {
		given()
		.queryParam("teamSize",10)
		.when().get("http://49.249.28.218:8091/project")
		.then().log().all();
	}
}
