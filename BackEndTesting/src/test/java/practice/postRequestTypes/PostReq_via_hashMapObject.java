package practice.postRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class PostReq_via_hashMapObject {
	public void postDataIntoServer() {
		HashMap<String,Object> map= new HashMap();//to create object for json before adding body using request specification
		map.put("createdBy", "gopika");
		map.put("projectName", "abc14");
		map.put("status", "Created");
		map.put("teamSize", 0);
	
		given().contentType(ContentType.JSON)
		.body(map)
		.when().post("http://49.249.28.218:8091/project/NH_PROJ_727")
		.then().assertThat().statusCode(200).log().all();
		
	
	}
}
