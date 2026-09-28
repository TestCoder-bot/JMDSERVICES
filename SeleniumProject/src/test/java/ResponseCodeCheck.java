

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

public class ResponseCodeCheck {

    public static void main(String[] args) {
        // Define the URL
        String amazonUrl = "https://www.amazon.com";

        // Perform a GET request to Amazon site and store the response
        Response response = RestAssured.get(amazonUrl);

        // Print the response status code
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);

        // Assert that the status code is 200 (OK)
        assertEquals(statusCode, 503, "The status code is not 200. Test Failed!");

        // Optionally, print the response time
        long responseTime = response.getTime();
        System.out.println("Response Time: " + responseTime + " ms");
    }
}