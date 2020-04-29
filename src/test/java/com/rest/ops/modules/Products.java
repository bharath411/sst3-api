package com.rest.ops.modules;

import com.rest.ops.commons.constants.Endpoints;
import com.rest.ops.commons.datahandlers.PropertiesHandler;
import com.rest.ops.pojo.OPSResponse;
import com.rest.ops.pojo.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Products {

	
	String token = Authentication.token;
	
	public OPSResponse createProduct(Product product) {
		
		PropertiesHandler ph  =new PropertiesHandler();
		String baseUrl = ph.getProperty("baseUrl");
		
		
		Response  response = RestAssured
				.given()
				.headers("Content-Type", "application/json")
				.headers("Authorization","Bearer " +token)
				.body(product)
				.post(baseUrl + Endpoints.PRODUCTS_URL);
		
		OPSResponse resp = response.getBody().as(OPSResponse.class);
		
		return resp;
	}
}
