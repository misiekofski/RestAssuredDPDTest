package config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static common.ConfigFactory.getDefaultConfig;

public class CentralConfigDemoTest {

    @BeforeClass
    void setup() {
        RestAssured.config = getDefaultConfig();
    }


    @Test
    public void someTest() {
        RestAssured.get("https://api.github.com/users/misiekofski")
                .then()
                .statusCode(204);
    }

}
