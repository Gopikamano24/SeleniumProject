
package typesOfParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class ParmParam {

	
	@Test
	public void parmParameter() {
		given()
		.param("projectId", "NH_PROJ_969")
		.log().all()
		.when().get("http://49.249.28.218:8091/project")
		.then().log().all();
	}
}
