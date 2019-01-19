package com.restassured.requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.*;

import org.junit.Test;
public class Customer {
	
	
	String id ="";
	String email = "";
	
	@Test
	public void createACustomer(){
		Response response = given().auth().basic("sk_test_PiIsczLkV5UFPn5DoR8juFs0", "").when().
		formParam("description", "creating my first customer through rest assured").
		formParam("email", "xyz@maroof.com").post("https://api.stripe.com/v1/customers").
		then().extract().response();
		System.out.println("response in create method is "+response.asString());
		//System.out.println(response.statusCode());
       JsonPath jsonP =  new JsonPath(response.asString());
       id = jsonP.get("id");
       email = jsonP.get("email");
      System.out.println(id);
      System.out.println(email);
      System.out.println(jsonP.get("sources.has_more"));
       
       
		
			
	}	
	
	@Test
	public void getACustomer(){
		Response response = given().auth().basic("sk_test_PiIsczLkV5UFPn5DoR8juFs0", "").request(Method.GET, "https://api.stripe.com/v1/customers/"+id+"").
		
		then().extract().response();
		System.out.println("response in get method is "+response.asString());
		System.out.println("status in get method is "+response.statusCode());
		
		
	}
	
	@Test
	public void updateACustomer(){
		Response response = given().auth().basic("sk_test_PiIsczLkV5UFPn5DoR8juFs0", "").when().formParam("email", "xyyz@maroof.com").request(Method.POST, "https://api.stripe.com/v1/customers/"+id+"").
		
		then().extract().response();
		System.out.println("response in update method is  "+response.asString());
		System.out.println("status in update method "+response.statusCode());
		
		
	}
	
	
	
	@Test
	public void deleteACustomer(){
		Response response = given().auth().basic("sk_test_PiIsczLkV5UFPn5DoR8juFs0", "").request(Method.DELETE, "https://api.stripe.com/v1/customers/"+id+"").
		
		then().extract().response();
		System.out.println("response in delete method is  "+response.asString());
		System.out.println("status in delete method "+response.statusCode());
		
		
	}
	
	public static void main(String[] args){
		
	
			Customer c = new Customer();
			c.createACustomer();
			/*c.getACustomer();
			c.updateACustomer();
			c.deleteACustomer();*/
	

}
}
