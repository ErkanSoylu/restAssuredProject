import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class RestAssuredTestts {
    @Test
    public String loginUserService() {

        RestAssured.baseURI = "https://dev2.roketapp.site/identity/user/login";

        // Create a JSON object with the login credentials
        JSONObject loginCredentials = new JSONObject();
        loginCredentials.put("phoneNumber", "+905054881393");
        loginCredentials.put("password", "Cc123-");

        // Create a request specification
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        // Set the request body to the login credentials
        request.body(loginCredentials.toString());

        // Make the POST request
        Response response = request.post();
        int statusCode = response.getStatusCode();
        // Print the response status code
        System.out.println("Response status code: " + response.getStatusCode());

        // Print the response body
        System.out.println("Response body: " + response.getBody().asString());
        // Check Response is success
        // Check if the status code is in the range 200-299
        if (statusCode >= 200 && statusCode < 300) {
            System.out.println("Response is a success");
        } else {
            System.out.println("Response is not a success");
        }
        JSONObject responseJson = new JSONObject(response.getBody().asString());
        String token = null;
        if (responseJson.has("token")) {
            token = responseJson.getString("token");
        }

        return token;
    }


    @Test
    public void getUserInfo() {
        // Get the token from the loginUserService method
        String token = loginUserService();
        if (token == null) {
            System.out.println("Error: Token field not found in response");
            return;
        }

        RestAssured.baseURI = "https://dev2.roketapp.site/identity/user";

        // Create a request specification
        RequestSpecification request = RestAssured.given();

        // Set the authorization header with the token
        request.header("Authorization", "Bearer " + token);

        // Make the GET request
        Response response = request.get();
        int statusCode = response.getStatusCode();
        // Print the response status code
        System.out.println("Response status code: " + response.getStatusCode());

        // Print the response body
        System.out.println("Response body: " + response.getBody().asString());
        // Check if the status code is in the range 200-299
        if (statusCode >= 200 && statusCode < 300) {
            System.out.println("Response is a success");
        } else {
            System.out.println("Response is not a success");
        }
    }
}
