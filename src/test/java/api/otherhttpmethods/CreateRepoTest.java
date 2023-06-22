package api.otherhttpmethods;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateRepoTest {
    private String TOKEN = "xxxxxxx";
    private String JSON_BODY_V11 = "{\"name\": \"delete_me\"}";

    private String JSON_BODY_V17 =
    """
    { "name" : "delete_me_zedytowane" }
    """;

    @Test
    public void shouldCreateRepositoryOnGithub() {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body(JSON_BODY_V11)
                .when()
                    .post("https://api.github.com/user/repos")
                .then()
                    .statusCode(201);
    }

    @Test(dependsOnMethods = "shouldCreateRepositoryOnGithub")
    public void shouldEditRepositoryOnGithub() {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body(JSON_BODY_V17)
                .when()
                    .patch("https://api.github.com/repos/misiekofski/delete_me")
                .then()
                    .statusCode(200);
    }

    @Test(dependsOnMethods = "shouldEditRepositoryOnGithub")
    public void deleteOldRepo() {
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                .when()
                    .delete("https://api.github.com/repos/misiekofski/delete_me_too")
                .then()
                    .statusCode(204);
    }

}
