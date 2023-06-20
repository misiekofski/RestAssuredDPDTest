package start;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstApiCallTest {
    @Test
    public void getFirstApiCall() {
        long responseTime = RestAssured
                .get("https://api.github.com/")
                .getTime();

        System.out.println("Response time: " + responseTime);
    }

    @Test
    public void getAllLidias() {
        long responseTime = RestAssured
                .get("https://api.github.com/search/users?q=lidia")
                .getTime();

        System.out.println("Response time: " + responseTime);
    }

    //
}
