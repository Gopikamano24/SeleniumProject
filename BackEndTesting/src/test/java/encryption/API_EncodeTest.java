package encryption;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class API_EncodeTest {

	
	@Test
	public void sample() {
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when().get("http://49.249.218:8091/projects")
		.then().log().all();
	}
	
}
