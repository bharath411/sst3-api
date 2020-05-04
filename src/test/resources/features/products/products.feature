#Author: bharath.kristipati@gmai.com

Feature: Verify Products Endpoints
  I want to use this endpoint to create, get and delete the products 

  Scenario: Verify Create Product
    Given Bearer token generated
    When Create a new product with "Camera","DSLR Product",0 , 6012 , 100 , 1 ,"CAM-6003","Nixon ABC","1", 0, 0, 0 details
    Then Verify "Product Added" message

  Scenario: Verify Create Product with Invalid Data
    Given Bearer token generated
    When Create a new product with "Camera","DSLR Product",0 , 6005 , 100 , 1 ,"CAM-6003","Nixon ABC","1", 0, 0, 0 details
    Then Verify "Unable to add Product - Product allready exist " message
    
  Scenario: Verify Create Product with new Data
    Given Bearer token generated
    When Create a new product with "Camera","DSLR Product",0 , 6013 , 100 , 1 ,"CAM-6003","Nixon ABC","1", 0, 0, 0 details
    Then Verify "Product Added" message
 
  Scenario: Verify Create Product with second new
    Given Bearer token generated
    When Create a new product with "Camera","DSLR Product",0 , 6014 , 100 , 1 ,"CAM-6003","Nixon ABC","1", 0, 0, 0 details
    Then Verify "Product Added" message