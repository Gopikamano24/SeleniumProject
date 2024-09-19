package encryption;

import org.testng.annotations.Test;
import encryption.EncryptandDecryptUtility;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayrollInfoViaASEEncryption {

	@Test
	public void SampleTest() throws Throwable {
		
		EncryptandDecryptUtility ed= new EncryptandDecryptUtility();
		
		String jBody="{ \"employee\": { \"empId\":\"NH_00102\", \"designation\": \"Tester\", \"dob\": \"24/12/1999\", \"email\": \"gopika@gmail.com\", \"empName\": \"user_1740\", \"experience\": 4, \"mobileNo\": \"9897969594\", \"project\": \"bsnl_1740	\", \"role\": \"Tester\", \"username\": “user_1740” }, \"basicPlusVda\": 0, \"hra\": 50000, \"insurance\": 3000, \"lta\": 5000, \"lwf\": 5000, \"netPay\": 0, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active” }";
		String jsonbody=ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		
		
		Response res=given()
		.body(jsonbody)
		.when()
		.put("http://49.249.28.218:8091/payroll");
		
		res.then().log().all();
		
		String resbody= ed.decrypt(res.getBody().asString(), "Ac03tEam@j!tu_#1");
		System.out.println(resbody);
	}
	
	
}
