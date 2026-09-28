
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Rest {

    @Test
    public void testLoginWithValidQueryParams() {
        // Base URI of the API
        RestAssured.baseURI = "http://192.168.1.228:8080"; // Replace with your API base URL

        // Send GET request with query parameters
        Response response = given()
                .queryParam("email", "admin@bitcomm.co.in")
                .queryParam("password", "admin%987")
                .get("http://192.168.1.228:8080/edge/api/user/login"); // Endpoint for login

        // Assert the status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

        // Assert response body (example for token validation)
        response.then()
                .body("token", notNullValue()) // Check that the token is present
                .body("email", equalTo("admin")); // Check returned username matches

        // Print response for debugging
        System.out.println("Response: " + response.asString());
    }
}
