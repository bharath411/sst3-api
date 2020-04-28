package com.rest.ops.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeStepDef {

	@Given("Bearer token is avaible")
	public void bearer_token_is_avaible() {
	    System.out.println("Bearer token is avaible");
	}

	@When("You Prepare Create emaployee {string}, {int}, {string} request")
	public void you_Prepare_Create_emaployee_request1(String name, Integer id, String email) {
		System.out.println("Request - " + " name  - " + name + ", id - " + id + " email - " + email) ;
		
		if(!email.contains("@")) {
			Assert.fail("Not valid format");
		}
	}
	
	@When("You Prepare Create emaployee {string},{string},{string} request")
	public void you_Prepare_Create_emaployee_request2(String name, String id, String email) {
		System.out.println("Request - " + " name  - " + name + ", id - " + id + " email - " + email) ;
		
		if(!email.contains("@")) {
			Assert.fail("Not valid format");
		}
	}	
	
	@And("send the post call")
	public void send_the_post_call() {
	    System.out.println("send the post call");
	}

	@Then("Validate {int} response code")
	public void validate_response_code(Integer statusCode) {
	   System.out.println("Status code is " + statusCode);
	}

	@Then("Validate {string} message in body")
	public void validate_message_in_body(String message) {
		System.out.println("Response body verification " + message );
	}
	
	
	@When("Create employee with data :")
	public void create_employee_with_data(DataTable dataTable) {

		List<Map<String,String>> listOfMaps = dataTable.asMaps();
		
		for (Map<String, String> map : listOfMaps) {
			
			for (String key : map.keySet()) {
				
				String value = map.get(key);
				
				System.out.println( key + " - " + value);
			}
			
			System.out.println("--------------------------");
		}
	}

	
}
