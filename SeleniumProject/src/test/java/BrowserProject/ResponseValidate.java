package BrowserProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
@SuppressWarnings("unused")
public class ResponseValidate {
	 RequestSpecification requestSpecification;
	    Response response;
	@Test
	 public void verifyStatusCode() {
		 
        RestAssured.baseURI = "http://amazon.in";
 
        // Create a request specification
        requestSpecification = RestAssured.given();
 
        // Calling GET method
        response = requestSpecification.get();
 
        // Let's print response body.
        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);
 
        // Get status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
 
        // Get status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
//public static void main (String[] args) throws InterruptedException {
//	RestAssured.baseURI="https://www.flipkart.com/";
//	RequestSpecification requestSpecification;
//	Response response;
//	
//	requestSpecification = RestAssured.given();
//	response=requestSpecification.get();
//	int statuCode= response.getStatusCode();
//	System.out.println("Response code is"+ statuCode);
//	Thread.sleep(3000);
//	String resString= response.prettyPrint();
//	System.out.println("Response Body is"+response );
//	Assert.assertEquals(statuCode, 200);

}
}
