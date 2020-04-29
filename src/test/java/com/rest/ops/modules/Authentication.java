package com.rest.ops.modules;

import org.testng.Assert;

import com.rest.ops.pojo.AuthResponse;
import com.rest.ops.pojo.Cred;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Authentication {

	public static String token = "";
	
	public void generateToken() {
		RestAssured.defaultParser = Parser.JSON;
		String url  = "http://localhost:9119/session";
		
		Cred cred = new Cred();
		cred.setUsername("demo");
		cred.setPassword("demo");
		
		
		Response response = RestAssured
		.given()
		.headers("Content-Type", "application/json")
		.body(cred)
		.post(url);
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		AuthResponse auth = response.getBody().as(AuthResponse.class);
		token = auth.getItem().getToken();
		System.out.println(token);
		
	}
}
