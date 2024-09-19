package practice.postRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class PostReq_via_jsonObject {
	public void postDataIntoServer() {
		JSONObject jsonObj=new JSONObject();//to create object for json before adding body using request specification
		jsonObj.put("createdBy", "gopika");
		jsonObj.put("projectName", "abc14");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
	
		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when().post("http://49.249.28.218:8091/project/NH_PROJ_727")
		.then().assertThat().statusCode(200).log().all();
		
	
	}
}
