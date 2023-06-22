package myobj;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnotherUser {
    @JsonProperty("data")
    public UserData userData;

    @JsonProperty("support")
    public Support support;

    public UserData getUserData() {
        return userData;
    }

    public Support getSupport() {
        return support;
    }
}
