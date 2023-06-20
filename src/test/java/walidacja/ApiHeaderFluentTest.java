package walidacja;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ApiHeaderFluentTest {
    @Test
    public void validateHeaders() {
        RestAssured.get("https://api.github.com/users/misiekofski")
                .then()
                    .statusCode(200)
                .and()
                    .contentType("application/json; charset=utf-9");
    }
}
