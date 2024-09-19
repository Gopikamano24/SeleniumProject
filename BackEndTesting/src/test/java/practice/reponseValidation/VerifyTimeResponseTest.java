
package practice.reponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyTimeResponseTest {

	@Test
	public void verifyHeader() {
		Response resp= given().get("http://49.249.28.218:8091/projects");
		 resp.then().log().all();
		  
		 long timeTaken = resp.time();
		 long timeTakenSec = resp.timeIn(TimeUnit.SECONDS);
		 
		 System.out.println(timeTaken);
		 System.out.println(timeTakenSec);
		 
		 resp.then().time( Matchers.lessThan(8000L));
		 
		 resp.then().assertThat().time(Matchers.greaterThan(300L));
		 
		 resp.then().assertThat().time(Matchers.both(Matchers.lessThan(8000L)).and(Matchers.greaterThan(300L)));
		 
		}
	
}
