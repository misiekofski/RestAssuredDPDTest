package api.otherhttpmethods;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.urls.ApiEndpoints;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;

public class HeadAndOptionsTest {
    @BeforeClass
    public void setUpRestAssured() {
        RestAssured.baseURI = ApiEndpoints.API_ROOT_URL;
    }

    @Test
    public void headTest() {
        RestAssured
                .head()
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    public void optionsTest() {
        RestAssured.options(RestAssured.baseURI + "emojis")
                .then()
                .statusCode(204)
                .header("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }
}
