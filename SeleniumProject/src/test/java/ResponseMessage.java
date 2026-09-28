

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ResponseMessage {

    @Test
    public void verifyAPIResponse() {
        // Define the base URL of the API
        String baseUrl = "https://jsonplaceholder.typicode.com/posts/1"; // Example API
        
        // Perform a GET request to the API and store the response
        Response response = RestAssured.get(baseUrl);
        
        // Verify the status code is 200 (OK)
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        // Extract response body as a String
        String jsonResponse = response.getBody().asString();
        System.out.println("Response JSON: " + jsonResponse);

        // Convert the response body to a JSON object using JsonPath
        JsonPath jsonPath = new JsonPath(jsonResponse);

        // Extract individual fields from the JSON response
        int userId = jsonPath.getInt("userId");
        int id = jsonPath.getInt("id");
        String title = jsonPath.getString("title");
        String body = jsonPath.getString("body");

        // Print extracted fields
        System.out.println("User ID: " + userId);
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Body: " + body);

        // Verify the values using TestNG assertions
        Assert.assertEquals(userId, 1, "User ID does not match!");
        Assert.assertEquals(id, 1, "ID does not match!");
        Assert.assertTrue(title.contains("sunt"), "Title does not contain expected text!");

        // Alternatively, use Rest Assured's built-in assertion methods
        response.then().body("userId", equalTo(1));
        response.then().body("id", equalTo(1));
        response.then().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void verifyResponseContentType() {
        // Define the base URL of the API
        String baseUrl = "https://jsonplaceholder.typicode.com/posts/1";
        
        // Perform a GET request to the API and store the response
        Response response = given()
            .when()
            .get(baseUrl)
            .then()
            .assertThat()
            .contentType("application/json; charset=utf-8")
            .extract()
            .response();

        // Extract the content-type from headers
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Content-Type does not match");
    }
}
