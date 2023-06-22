package api.config;

import api.common.ConfigFactory;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CentralConfigDemoTest {

    @BeforeClass
    void setup() {
        RestAssured.config = ConfigFactory.getDefaultConfig();
    }


    @Test
    public void someTest() {
        RestAssured.get("https://api.github.com/users/misiekofski")
                .then()
                .statusCode(204);
    }

}
