package com.rest.ops.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = "src/test/resources/features/employee/employee.feature" ,
				 glue ="com.rest.ops",
				 plugin= {"pretty", "json:target/cucumber/report.json","html:target/cucumber-report" }
		)

//cucumber-reporting:target/pretty-cucumber
//"html:target/cucumber-reports"
public class EmployeeRunner  extends AbstractTestNGCucumberTests{

}
