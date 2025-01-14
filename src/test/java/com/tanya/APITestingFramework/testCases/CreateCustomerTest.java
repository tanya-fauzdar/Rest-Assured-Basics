package com.tanya.APITestingFramework.testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateCustomerTest {
	@Test
	public void validateCreateCustomerAPIWithValidSecretKey() {
		
		Response response = given().auth().basic("someValidSecretKey", "")
		.formParam("email", "tanyasingh1454@gmail.com").formParam("description", "Adding the first customer in framework")
		.post("https://api.stripe.com/v1/customers");
		
		response.prettyPrint();
		
		System.out.println("---POST API Status Code is: " + response.statusCode());
		
		//Now validating the api response with status code using Assert of TestNG
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@Test
	public void validateCreateCustomerAPIWithInvalidSecretKey() {
		
		Response response = given().auth().basic("someinvalidsecretkey", "")
		.formParam("email", "tanyasingh1454@gmail.com").formParam("description", "Adding the first customer in framework")
		.post("https://api.stripe.com/v1/customers");
		
		response.prettyPrint();
		System.out.println();
		System.out.println("---POST API Status Code is: " + response.statusCode());
		
		/* Now validating the api response with status code using Assert of TestNG
		 * 
		 * Assert.assertEquals(response.statusCode(), 200);
		 * 
		 * The above should fail the test case as the expected status code is 200 but actual
		 * comes to be 401 due to the invalid secret key.
		 * 
		 */
		
		
		//for validating this invalid secret key negative scenario, by asserting on secret code on failure 401
		Assert.assertEquals(response.statusCode(), 401);
	}

}
