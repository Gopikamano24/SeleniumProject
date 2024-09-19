package typesOfParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class FormParam {

	
	@Test
	public void formParameter() {
		given()
		.formParam("teamSize", "0")
		.log().all()
		.when().post("http://49.249.28.218:8091/project")
		.then().log().all();
	}
}
