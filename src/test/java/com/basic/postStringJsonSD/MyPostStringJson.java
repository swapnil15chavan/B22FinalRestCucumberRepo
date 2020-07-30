package com.basic.postStringJsonSD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Assert;

public class MyPostStringJson {
	 
	Response resp ;
	
	@Given("^user hit the post request from String$")
	public void user_hit_the_post_request_with_String() throws IOException{
		
		
		
		resp = RestAssured.given().accept(ContentType.JSON).relaxedHTTPSValidation().
				when().body("{ \"name\": \"Madhuri\", \"job\":\"QA consultant\"}").post("https://reqres.in/api/users");
//		resp.then().log().all();
//		resp.then().log().status();
		System.out.println("====="+resp.asString());
		System.out.println("status code is = "+resp.getStatusCode());
		
		
	}
	
	@Then("user validate the id is not null")
	public void user_validate_the_id_is_not_null(){
		
		//Check id is not null
		resp.then().assertThat().body("id", notNullValue());
		
		//check id is greater than zero
		String idValue = resp.getBody().jsonPath().get("id");
		int idInt = Integer.parseInt(idValue);
		Assert.assertTrue(idInt > 0);
		
		//validate the date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String todaysDate = dateFormat.format(date);
		
		String createdAtValue = resp.getBody().jsonPath().get("createdAt");
		Assert.assertTrue(createdAtValue.contains(todaysDate));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
 