package apitesting;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
/*import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
*/


public class SendGetReqWithRestAssured {
	
public static void main(String[] args) {
		
		Response response = given().auth().basic("sk_test_51QeGnuDj0R1qTIFyrT8erMa2DTMfT51uc0Kzd3j3uK5a8sXNynKicPZiFxHDqhhI5iwxE1wwxzw72nnXMGbjJyZk00NIqIPp5C", "")
				.get("https://api.stripe.com/v1/customers");
		
		//response.prettyPrint();
		
		String jsonResponse = response.asString(); //just to know, we ca save jason response as string and print
		
		System.out.println(jsonResponse);
		
	
	}

}
