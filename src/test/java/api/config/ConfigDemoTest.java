package api.config;

import io.restassured.RestAssured;
import io.restassured.listener.ResponseValidationFailureListener;
import org.testng.annotations.Test;

import static io.restassured.config.FailureConfig.failureConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;

public class ConfigDemoTest {

    @Test
    public void maxRedirectTest() {

        // https://api.github.com/repos/twitter/bootstrap
        // chce dostać 200
        RestAssured.config = RestAssured.config()
                        .redirect(
                                redirectConfig()
                                        .followRedirects(true)
                                        .maxRedirects(0)
                        );

        RestAssured.get("https://api.github.com/repos/twitter/bootstrap")
                .then()
                .statusCode(200);
    }

    ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
            System.out.printf("We have a failure, " +
                            "response status was %s and the body contained: %s",
                    response.getStatusCode(), response.body().asPrettyString());

    @Test
    public void failureConfigTest() {
        RestAssured.config = RestAssured.config()
                .failureConfig(
                        failureConfig()
                                .failureListeners(failureListener)
                );

        RestAssured.get("https://api.github.com/repos/misiekofski/RestTestingFrameworkDPDDD")
                .then()
                .statusCode(200);
    }
}
