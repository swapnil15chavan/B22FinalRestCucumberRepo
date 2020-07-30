package com.basic.postUpdatedJsonSD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.Assert;

public class MyPostFromTextFile {
	 
	Response resp ;
	
	@Given("^user hit the post request with \"([^\"]*)\" name and \"([^\"]*)\" job$")
	public void user_hit_the_post_request_with_json_data(String username, String jobname) throws IOException{
		
		//Read data from file
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get("src/test/java/com/basic/postUpdatedJsonSD/user.json"))); 
	    System.out.println("json in String ==== " +data);
	    
	    //Update the data
	    JSONObject object=new JSONObject(data);
	    object.put("name", username);
	    object.put("job", jobname);
	    String newJsonStr = object.toString();
	    System.out.println("json in String ==== " +newJsonStr);
	    
	    //Do POST request
	    resp = RestAssured.given().accept(ContentType.JSON).relaxedHTTPSValidation().
				when().body(newJsonStr).post("https://reqres.in/api/users");
	}
	
	@Then("user validate the id is not null")
	public void user_validate_the_id_is_not_null(){
		
		//Check id is not null
		resp.then().assertThat().body("id", notNullValue());
		
		//check id is greater than zero
		String idValue = resp.getBody().jsonPath().get("id");
		int idInt = Integer.parseInt(idValue);
		Assert.assertTrue(idInt > 0);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
 