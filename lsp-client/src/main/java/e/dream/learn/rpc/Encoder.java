package e.dream.learn.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/* encode a message in JSON-RCP 2.0 to send to a lsp server. */
public final class Encoder {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Optional<byte[]> encodeMsg(Object object) {
        if (object == null) return Optional.empty();

        // convert the value into a JSON value.
        try {
            byte[] body = mapper.writeValueAsBytes(object);
            byte[] header = ("Content-Length: " + body.length + "\r\n\r\n") // construct a string.
                    .getBytes(StandardCharsets.US_ASCII); // extract the byte out it.

            return Optional.of(
                    ByteBuffer
                            .allocate(header.length + body.length)
                            .put(header)
                            .put(body)
                            .array()
            );
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(
                    "not serializable: " + object.getClass().getName(), e
            );
        }
    }

    // TODO: implement the decoding later.

}

