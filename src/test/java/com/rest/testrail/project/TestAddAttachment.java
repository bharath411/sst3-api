package com.rest.testrail.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAddAttachment {

	
	String baseUrl = "https://sst3slokam.testrail.io/index.php?/api/v2";
	String username = "bharath.selenium24@gmail.com";
	String password = "ul/R73XTk1p0RywdDcXU-/7YlaK5PlErnzY7Y//ur";
	Header header1 = new Header("Content-Type","application/json");
	Header header2 = new Header("Content-Type","multipart/form-data");
	
	String getProjectsUrl = "/get_project/";
	String getSuitesUrl = "/get_suites/1";
	String getUsersUrl = "/get_users";
	String addRunUrl = "/add_run/";
	String getTestsUrl="/get_tests/";
	String addResultUrl = "/add_result/";
	String addAttachmentToResultUrl ="/add_attachment_to_result/";
	String closeRunUrl = "/close_run/6";
	String getAttachmentUrl = "/get_attachment/";
	
	
	@Test
	public void testAttachment() {
		
		String projectId  = "1";
		// Get Projects
		
		String addRunBody  = "{\n" + 
				"	\"suite_id\": 1,\n" + 
				"	\"name\": \"My test run from restassured\",\n" + 
				"	\"assignedto_id\": 1,\n" + 
				"    \"refs\": \"SAN-1, SAN-2\",\n" + 
				"	\"include_all\": true\n" + 
				"	\n" + 
				"}";
		Response response = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header(header1)
				.body(addRunBody)
				.post(baseUrl + addRunUrl + projectId);
		
		response.then().assertThat().statusCode(200).and().body("suite_id", Matchers.equalTo(1));
		
		String responseBody = response.getBody().asString();
		
		JsonPath jp = new JsonPath(responseBody);
		int runId = jp.get("id");
		System.out.println(runId);
		
		Response response2 = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header(header1)
				.get(baseUrl + getTestsUrl + runId);
		response2.then().assertThat().statusCode(200);
		
		 responseBody = response2.getBody().asString();
		 
		 JsonPath jp2 =  new JsonPath(responseBody);
		 List<Integer> list = jp2.getList("id");
		 
		 int testId = list.get(0); 
		 
		 System.out.println(testId);
		 
		 String resultBody = "{\n" + 
		 		"	\"status_id\": 5,\n" + 
		 		"	\"comment\": \"This test failed\",\n" + 
		 		"	\"elapsed\": \"15s\",\n" + 
		 		"	\"defects\": \"TR-7\",\n" + 
		 		"	\"version\": \"1.0 RC1 build 3724\",\n" + 
		 		"\n" + 
		 		"	\"custom_step_results\": [\n" + 
		 		"		{\n" + 
		 		"			\"content\": \"Step 1\",\n" + 
		 		"			\"expected\": \"Expected Result 1\",\n" + 
		 		"			\"actual\": \"Actual Result 1\",\n" + 
		 		"			\"status_id\": 1\n" + 
		 		"		}\n" + 
		 		"	]\n" + 
		 		"}";
		 
		 response = RestAssured
					.given()
					.auth()
					.preemptive()
					.basic(username, password)
					.header(header1)
					.body(resultBody)
					.post(baseUrl + addResultUrl + testId);
		 
		 response.then().assertThat().statusCode(200);
		 responseBody = response.getBody().asString();
		 
		 
		 int resultId = new JsonPath(responseBody).getInt("id");
		 
		 System.out.println(resultId);
		 
	}
	
	
	@Test
	public void testAttachment1() {
		Response response = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header(header2)
				.multiPart("attachment" , new File("/Users/bharathkumarreddy/Documents/Git-Logo-1788C.png"))
				.post(baseUrl + addAttachmentToResultUrl + 7);
		
		System.out.println(response.getBody().asString());
		
		
		
	}
	
	@Test
	public void getAttachment() {
		Response response2 = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic(username, password)
				.header(header1)
				.get(baseUrl + getAttachmentUrl + 9);
		
		byte[] st = response2.body().asByteArray();
		try {
			FileOutputStream fos = new FileOutputStream(new File("sample.png"));
			fos.write(st);
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
