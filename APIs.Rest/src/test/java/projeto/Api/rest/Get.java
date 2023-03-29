package projeto.Api.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
	@Test

	public void statusCode() {

		Response response = RestAssured.get("http://challengeqa.staging.devmuch.io/10000");
		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		assertEquals(200, code);

	}
	
	
	
}