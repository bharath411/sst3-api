package com.rest.ops;

import java.io.File;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rest.ops.pojo.Cred;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OPSProducts {

	public String getToken() {
		
		String expectedOperationStatus = "SUCCESS";
		String url  = "http://localhost:9119/session";
		String jasonBody = "{\n" + 
				"	\"password\": \"demo\",\n" + 
				"	\"username\": \"demo\"\n" + 
				"}";
		
		Response response = RestAssured
		.given()
		.headers("Content-Type", "application/json")
		.body(jasonBody)
		.post(url);
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		String st = response.getBody().asString();
		System.out.println(st);
		
		//JSON
		
		JSONObject json = new JSONObject(st);
		String operationStatus = json.getString("operationStatus");
		System.out.println(operationStatus);
		Assert.assertEquals(operationStatus, expectedOperationStatus);
		
		JSONObject itemJson = json.getJSONObject("item");
		String token = itemJson.getString("token");
		System.out.println(token);
		return token;
	}
	
public String getTokenWithJsonFile() {
		
		String expectedOperationStatus = "SUCCESS";
		String url  = "http://localhost:9119/session";
		
		File file = new File("./src/test/resources/login.json");
		Response response = RestAssured
		.given()
		.headers("Content-Type", "application/json")
		.body(file)
		.post(url);
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		String st = response.getBody().asString();
		System.out.println(st);
		
		//JSON
		
		JSONObject json = new JSONObject(st);
		String operationStatus = json.getString("operationStatus");
		System.out.println(operationStatus);
		Assert.assertEquals(operationStatus, expectedOperationStatus);
		
		JSONObject itemJson = json.getJSONObject("item");
		String token = itemJson.getString("token");
		System.out.println(token);
		return token;
	}
	
//serialization
public String getTokenWithAsJavaObject() {
	
	String expectedOperationStatus = "SUCCESS";
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
	
	String st = response.getBody().asString();
	
	//JSON
	
	JSONObject json = new JSONObject(st);
	String operationStatus = json.getString("operationStatus");
	System.out.println(operationStatus);
	Assert.assertEquals(operationStatus, expectedOperationStatus);
	
	JSONObject itemJson = json.getJSONObject("item");
	String token = itemJson.getString("token");
	return token;
}

	@Test
	public void test1() {
		String token = getTokenWithAsJavaObject();
		System.out.println(token);
	}
	
	@Test
	public void testProducts() {
		String url = "http://localhost:9119/api/products";
		String token = getToken();
		Response resp = RestAssured
				.given()
				.headers("Authorization", "Bearer " + token)
				.get(url);
		
		String st = resp.getBody().asString();
		System.out.println(st);
	}
	
	
	
}
