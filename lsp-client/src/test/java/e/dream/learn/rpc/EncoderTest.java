package e.dream.learn.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.*;
import static org.assertj.core.api.Assertions.*;

record User(String username, Integer age, String sex) {
}

class EncoderTest {

    static User user;

    private static final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    static void setup() {

        user = new User("miguel", 19, "male");

    }

    @Test
    void shouldEncodeMsg() throws JsonProcessingException {

        byte[] frame = Encoder.encodeMsg(user).orElseThrow();
        String msg = new String(frame, UTF_8);
        String[] parts = msg.split("\r\n\r\n");

        assertThat(parts[0]).isEqualTo("Content-Length: 43");
        assertThat(mapper.readTree(parts[1]))
                .isEqualTo(mapper.readTree("{\"username\":\"miguel\",\"age\":19,\"sex\":\"male\"}"));

    }

    @Test
    void contentLengthMustCountBytes() {
        // 'é' is 2 bytes in UTF-8, the emoji is 4 — this fails on any char-based length
        assertFrameIsWellFormed(Encoder.encodeMsg(new User("José 😀", 19, "male")).orElseThrow());
    }

    private static void assertFrameIsWellFormed(byte[] frame) {
        String text = new String(frame, UTF_8);
        int sep = text.indexOf("\r\n\r\n");
        int declared = Integer.parseInt(
                text.substring(0, sep).replaceFirst("(?s).*Content-Length:\\s*(\\d+).*", "$1"));
        byte[] body = text.substring(sep + 4).getBytes(UTF_8);

        assertThat(body.length)
                .as("Content-Length must be the UTF-8 byte count of the body")
                .isEqualTo(declared);
        assertThatNoException().isThrownBy(() -> mapper.readTree(body));
    }

    @Test
    void shouldEncodeMsgBeEmpty() {
        assertThat(Encoder.encodeMsg(null)).isEmpty();
    }

    @Test
    void shouldThrowOnUnserializableObject() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Encoder.encodeMsg(new Object() { final Object self = this; }));
    }

}

