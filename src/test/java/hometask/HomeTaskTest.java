package hometask;

import io.restassured.RestAssured;
import myobj.AnotherUser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class HomeTaskTest {
    @Test
    public void requestUserParserTest() {

        AnotherUser user = RestAssured.get("https://reqres.in/api/users/2")
                        .as(AnotherUser.class);

        assertNotNull(user);

        assertEquals(user.getUserData().getId(), 2);
        assertEquals(user.getUserData().getEmail(), "janet.weaver@reqres.in");
    }
}
