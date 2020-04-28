package com.rest.ops;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class OPSProducts2 {

	@Test
	public void validateBadCreds() {
		
		RestAssured.defaultParser = Parser.JSON;
		
		
		String expectedOperationStatus = "SUCCESS";
		String url  = "http://localhost:9119/session";
		String jasonBody = "{\n" + 
				"	\"password\": \"demo123\",\n" + 
				"	\"username\": \"demo\"\n" + 
				"}";
		
		Response response = RestAssured
		.given()
		.headers("Content-Type", "application/json")
		.body(jasonBody)
		.post(url);
		
		response
		.then()
		.assertThat()
		.statusCode(401)
		.and()
		.body("message", Matchers.equalTo("Authentication Failed: Bad credentials") );
		
		
		
	}
	
	/*
	 * 
	 * 19.11.0.0
19.10.0.0
20.2.0.0
20.2.0.0
18.10.1.2
19.12.0.0
	 */
	
	public static void main(String[] args) {
		String line = "19.11.0.0";
	      String pattern = "(.*)(\\d+)(.*)";

	    
	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	      }else {
	         System.out.println("NO MATCH");
	      }
	   }
	
	
}
