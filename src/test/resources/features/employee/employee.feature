#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Employee Operations
  I want to verify create, read, delete operations of employee

Background:
	Given Bearer token is avaible
	
	
  @tag1
  Scenario: Verify Create new Employee
    
    When You Prepare Create emaployee "bharath", 12, "bharath@gmail.com" request
    And send the post call
    Then Validate 200 response code
    And Validate "Success" message in body
    
  @tag2
  Scenario: Verify Create new Employee with invalid data
    When You Prepare Create emaployee "bharath", 12, "bharath" request
    And send the post call
    Then Validate 200 response code
    And Validate "Success" message in body
    
  Scenario Outline: Cretate multiple users  
    When You Prepare Create emaployee "<firstname>","<id>","<email>" request
    And send the post call
    Then Validate 200 response code
    And Validate "Success" message in body
    
    Examples:
    	| firstname | id | email 							|
    	| bharath		| 14 | bharath@gmail.com	|
    	|	kumar			| 15 | sdfs@gmail.com			|
    	| kk				| 33 |	sdfsd@gmail.com		|
    	| sdfsddsfs	| 44 | sdfsdfdsfds				|
  
  
	Scenario: Verify Create multiple employees with single scenario
    When Create employee with data :
    	| firstname | id | email 							|
    	| abc				| 16 | abc@gmail.com			|
    	|	xyz				| 17 | xyz@gmail.com			|
    	| fasd			| 38 |	fasd@gmail.com		|
    	| ree				| 49 | ree							|
    And send the post call
    Then Validate 200 response code
    And Validate "Success" message in body

  
