package com.rest.testrail.project;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.rest.ops.pojo.TestRailProject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class TesProjects {
	
	String url = "https://sst3slokam.testrail.io/index.php?/api/v2/get_projects";
	String username = "username";
	String password = "Password";
	Header header = new Header("Content-Type","application/json");
	

	//header("Content-Type","application/json")
	@Test
	public void verifyAllProjects() {
		
		
		Response response = RestAssured
		.given()
		.auth()
		.preemptive()
		.basic(username, password)
		.header(header)
		.get(url);
		
		response
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("name", Matchers.hasItem("Ops"));
		
		
		String st = response.getBody().asString();
		
		JSONArray array = new JSONArray(st);
		
		int projectId = 0;
		String projectName = "Opencart";
		int size = array.length();
		for(int i=0; i<size; i++) {
			JSONObject jobj = (JSONObject)array.get(i);
			String tempProjectName = jobj.getString("name");
			if(tempProjectName.equals(projectName)) {
				projectId = jobj.getInt("id");
				break;
			}
		}
		
		System.out.println(projectId);
	}
	
	@Test
	public void verifyAGetProjectWithJava() {
		String url = "https://sst3slokam.testrail.io/index.php?/api/v2/get_project/1";
		Response response = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header(header)
				.get(url);
				
				TestRailProject project = response.as( TestRailProject.class);
				
				System.out.println(project.getName());
				System.out.println(project.getId());
	}
	
	@Test
	public void verifyAllProjectsWithJava() {
		String url = "https://sst3slokam.testrail.io/index.php?/api/v2/get_projects";
		Response response = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header(header)
				.get(url);
				
				TestRailProject[] project = response.as(TestRailProject[].class);
				
				for (TestRailProject testRailProject : project) {
					System.out.println(testRailProject.getId());
					System.out.println(testRailProject.getName());
				}
			
	}
	
	
}
