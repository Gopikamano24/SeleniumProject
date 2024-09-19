package panCardMock;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;

public class CreditCardMock {

	public static void main(String[] args) {

		Spark.port(8889);
		Spark.post("/credit-card", (req,res)->{ //if we send any json request it will be 
			//saved in req variable then we have to create mock and respond using res variable
			String response="";
			String card=JsonPath.read(req.body().toString(), "$.creditcard");
			//after getting details form that body verify that using below condition and
			//create response object
			if(StringUtils.equalsAny(card, "123456789098765","12345678912345","987654321098")) {
				//using StringUtils cls we can add multiple card details or
				//else only one we can use
				response="{\"status\":\"Payment success\"}";
				res.status(200);//to return the status code
			}
			else {
				response="{\"status\":\"Payment failed\"}";
				res.status(404);
			}
			res.type("application/json");//to get the response type in json
			return response;
		});
		System.out.println("---------------------Running-----------------------------");
	}
}
