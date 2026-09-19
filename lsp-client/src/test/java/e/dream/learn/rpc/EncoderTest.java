package e.dream.learn.rpc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

record User(String username, Integer age, String sex) {
}

class EncoderTest {

    static String userJson;
    static User user;
    static Encoder encoder;

    @BeforeAll
    static void setup() {

        user = new User("miguel", 19, "male");
        userJson = new StringBuilder()
                .append("Content-Length: 43\r\n")
                .append("Content-Type: utf-8\r\n\r\n")
                .append("{{\"username\":\"miguel\",\"age\":19,\"sex\":\"male\"}}")
                .toString();

        encoder = new Encoder();

    }

    @Test
    void ShouldEncodeMsg() {

        Optional<String> encodedMsg = encoder.encodeMsg(user); // encode the user object into a json-rpc object.

        assertThat(encodedMsg)
                .as("encode message return from encodeMsg must be equal to the  same object")
                .isPresent()
                .isNotEmpty()
                .get()
                .isEqualTo(userJson);
    }

    @Test
    void shouldEncodeMsgBeEmpty() {

        Optional<String> encodedMsg = encoder.encodeMsg(null);

        assertThat(encodedMsg)
                .as("encode message return from encodeMsg must be equal to the  same object")
                .isNotPresent()
                .isEmpty();
    }

}

