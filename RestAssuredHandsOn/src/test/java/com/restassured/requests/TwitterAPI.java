package com.restassured.requests;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TwitterAPI {
	
	public static void main(String[] args) {
		Response response = given().auth().oauth("BjApkejjTBjAJLSJqhrBwFSWR", "lCyAiJcBuafFgk2XExYKFS0nk6SyJB0Wb6xYYDalH3dX6U0m8y", "1049004757401001984-cGT2UHgJ2mk8FnZA8cfKfuAC0chg1U", "K5qyT8MTvD1UhiacR7AIWCxnd8dErdtIZ0Gs6Ch59meF4")
		.queryParam("status", "Good show by Mamta and Opposition and others").post("https://api.twitter.com/1.1/statuses/update.json").then().extract().response();
		
		
		System.out.println(response.prettyPrint());
		
		JsonPath jsonp = response.jsonPath();
		System.out.println("url is blank "+jsonp.get("user.entities.description.urls"));
		
	}

}
