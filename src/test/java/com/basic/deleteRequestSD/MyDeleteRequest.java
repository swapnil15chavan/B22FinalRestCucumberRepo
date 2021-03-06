package com.basic.deleteRequestSD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MyDeleteRequest {
	 
	Response resp ;
	
	@Given("^user hit the delete request$")
	public void user_hit_the_post_request_with_String() throws IOException{
		
		//Create User
		Response postRes = RestAssured.given().accept(ContentType.JSON)
				.relaxedHTTPSValidation()
				.when().body("{ \"name\": \"Madhuri\", \"job\":\"QA consultant\"}")
				.post("https://reqres.in/api/users");
		
		//get the id of user
		String userID = postRes.getBody().jsonPath().getString("id");
		
		//Delete user
		resp = RestAssured.given().accept(ContentType.JSON)
				.relaxedHTTPSValidation()
				.when().delete("https://reqres.in/api/users/"+userID);
		resp.then().log().all();
		resp.then().log().status();
		System.out.println("====="+resp.asString());
		
	}
	
	@Then("user validate the status code")
	public void user_validate_the_status_code(){
		
		//Check id is not null
		resp.then().assertThat().statusCode(204);
		
		//with regular assert
		//Assert.assertTrue(204==resp.getStatusCode());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
 