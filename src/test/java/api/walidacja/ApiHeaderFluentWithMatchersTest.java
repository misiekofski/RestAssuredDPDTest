package api.walidacja;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ApiHeaderFluentWithMatchersTest {

    @Test
    public void testStatusCodeWithMatchers() {
        RestAssured.get("https://api.github.com/users/misiekofski")
                .then()
                .statusCode(lessThan(300))
                .and()
                .statusCode(greaterThan(199))
                .and()
                .contentType(containsString("utf-8"));
    }
}
