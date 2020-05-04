package com.rest.ops.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = "src/test/resources/features/employee/employee.feature" ,
				 glue ="com.rest.ops",
				 plugin= {"pretty", "json:target/cucumber/employee.json","html:target/cucumber-report" }
		)

//cucumber-reporting:target/pretty-cucumber
//"html:target/cucumber-reports"
public class EmployeeRunner  extends AbstractTestNGCucumberTests{

	 @DataProvider
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
