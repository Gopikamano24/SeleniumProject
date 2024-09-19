package panCardMock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PaymentTest {

	@Test
	public void sampleTest() {
		JSONObject obj=new JSONObject();//bcz in mocking we mentioned req shb sent in json fmt
		obj.put("creditcard", "12345678912345");
		obj.put("cvv", "123");
		obj.put("cardName", "gopika");
		
		given()
		.contentType(ContentType.JSON)//bcz mocking solution is dev for json
		.body(obj)
		.when()
		.post("http://localhost:8889/credit-card")//bcz mocking soln is written for post()
		.then().log().all();
		
	}
}
