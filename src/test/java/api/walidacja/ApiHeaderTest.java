package api.walidacja;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiHeaderTest {
    @Test
    public void validateHeaders() {
        Response response = RestAssured.get("https://api.github.com/users/misiekofski");

        int actualStatusCode = response.getStatusCode();
        String contentType = response.getContentType();
        String contentEncondingHeaderValue = response.getHeader("content-encoding");

        System.out.println("Status code :" + actualStatusCode);
        System.out.println("Header content-encoding: " + contentEncondingHeaderValue);
        System.out.println("content type: " + contentType);

        Headers headers = response.getHeaders();
        System.out.println(headers);
    }
}
