package com.rest.ops.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions ( features = "src/test/resources/features/products/products.feature",
					glue = "com.rest.ops",
					plugin = { "pretty", "json:target/cucumber/product.json", "html:target/cucumber"}
		)
public class ProductsRunner extends AbstractTestNGCucumberTests{

}
