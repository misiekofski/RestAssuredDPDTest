package api.jsonpath;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;

public class JsonPathTest {

    @Test
    public void jsonPathTest() {

        String response = RestAssured.get("https://api.github.com/users/misiekofski/repos")
                .path("name");

        System.out.println(response);
    }
}
