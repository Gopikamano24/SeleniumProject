package reqChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;
public class Nimbbl {

	
	@Test
	public void payment() {
		//Generating token
	JSONObject jsonobj=new JSONObject();
	jsonobj.put("access_key", "access_key_pKx7rWVgVpbXQvq2");
	jsonobj.put("access_secret", "access_secret_DX3w55VKAkXbx7aB");
	
	Response res=given().contentType(ContentType.JSON)
			.body(jsonobj)
			.when().post("https://api.nimbbl.tech/api/v3/generate-token");
	res.then().log().all();
	String token=res.jsonPath().get("token");
	System.out.println("--------------------------tokenGenerated----------------------------");
	
	//Creating Order
	File file = new File("./resource/nimbbl_order.json");
	Response res1=given().contentType(ContentType.JSON)
			.header("Authorization", "Bearer "+token)
			.body(file)
			.when().post("https://api.nimbbl.tech/api/v3/create-order");
	res1.then().log().all();
	String orderid=res1.jsonPath().get("order_id");
	String usertoken=res1.jsonPath().get("user.token");
	System.out.println("----------------------------orderCreated------------------------------");
	
	//payment
	
	
	}
	
	
}
