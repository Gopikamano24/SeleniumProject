package typesOfParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PathParam {

	
	@Test
	public void pathParameter() {
		given()
		.pathParam("projectId", "NH_PROJ_969")
		.when().get("http://49.249.28.218:8091/project/{projectId}")
		.then().log().all();
	}
}
