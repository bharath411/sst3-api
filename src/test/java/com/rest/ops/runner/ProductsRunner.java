package com.rest.ops.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions ( features = "src/test/resources/features/products/products.feature",
					glue = "com.rest.ops",
					plugin = { "pretty", "json:target/cucumber/product.json", "html:target/cucumber"}
		)
public class ProductsRunner extends AbstractTestNGCucumberTests{

	 @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
