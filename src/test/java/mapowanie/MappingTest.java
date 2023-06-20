package mapowanie;

import io.restassured.RestAssured;
import myobj.User;
import org.testng.annotations.Test;

public class MappingTest {
    private static final String BASE_URL = "https://api.github.com/users/misiekofski";

    @Test
    public void objectMappingUserTest() {
        User user = RestAssured.get(BASE_URL)
                .as(User.class);

        System.out.println(user.getLogin());
        System.out.println(user.getId());
        System.out.println(user.getNodeId());

    }
}
