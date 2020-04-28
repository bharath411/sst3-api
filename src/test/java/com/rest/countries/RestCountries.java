package com.rest.countries;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class RestCountries {
		String url = "https://restcountries.eu/rest/v2/all";
	@Test
	public void fetchAllCountrys() {
		RestAssured ra = new RestAssured();
		Response response = ra.get(url);
		String respData = response.getBody().asString();
		
		System.out.println(respData);
	}
	
	@Test
	public void fetch2() {
		
		Response response =RestAssured.get(url);
		String respData = response.getBody().asString();
		System.out.println(respData);
	}
	
	@Test
	public void fetch3() {
		
		Response response = get(url);
		String respData = response.getBody().asString();
		System.out.println(respData);
	}
	
	// static import
}
