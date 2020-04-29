package com.rest.ops.steps;

import org.testng.Assert;

import com.rest.ops.modules.Authentication;
import com.rest.ops.modules.Products;
import com.rest.ops.pojo.OPSResponse;
import com.rest.ops.pojo.Product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepDef {
	OPSResponse response = null;
	@Given("Bearer token generated")
	public void bearer_token_generated() {
		Authentication auth = new Authentication();
		auth.generateToken();
		System.out.println("Bearer Token generated - " + Authentication.token);
	}

	@When("Create a new product with {string},{string},{int} , {int} , {int} , {int} ,{string},{string},{string}, {int}, {int}, {int} details")
	public void create_a_new_product_with_details(String category, String description, Integer discontinued,Integer id,Integer listPrice,
			Integer minimumReorderQuantity, String productCode,
			String productName, String quantityPerUnit, Integer reorderLevel, Integer standardCost, Integer targetLevel) {
		
		Products products = new Products();
		
		Product product = new Product();
		product.setCategory(category);
		product.setDescription(description);
		product.setId(id);
		product.setDiscontinued(discontinued);
		product.setListPrice(listPrice);
		product.setMinimumReorderQuantity(minimumReorderQuantity);
		product.setProductCode(productCode);
		product.setProductName(productName);
		product.setQuantityPerUnit(quantityPerUnit);
		product.setReorderLevel(reorderLevel);
		product.setStandardCost(standardCost);
		product.setTargetLevel(targetLevel);
		
		response = products.createProduct(product);
	}

	@Then("Verify {string} message")
	public void verify_product_created_with_message(String expectedMessage) {
		String actualMessage = response.getOperationMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
