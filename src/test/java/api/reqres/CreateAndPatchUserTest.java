package api.reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateAndPatchUserTest {
    String newUser = """
            {
                "name" : "morfeusz",
                "job" : "szef zionu"
            }
            """;

    String editedUser = """
            {
                "name" : "neo",
                "job" : "chosen one"
            }
            """;

    @Test
    public void createAndPatchUserTest() {

        Response response = RestAssured
                .given()
                    .body(newUser)
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .extract()
                    .response();

        // response.prettyPeek();

        String id = response.path("id");

        Response patchResponse = RestAssured
                .given()
                    .body(editedUser)
                .when()
                    .put("https://reqres.in/api/users/" + id)
                .then()
                    .extract()
                    .response();

        var updatedAt = patchResponse.path("updatedAt");
        System.out.println(updatedAt);

    }
}
