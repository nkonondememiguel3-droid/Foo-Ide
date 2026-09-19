package e.dream.learn.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

/* encode a message in JSON-RCP 2.0 to send to a lsp server. */
public class Encoder {

    private static ObjectMapper mapper;

    public Encoder() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
    }

    public Optional<String> encodeMsg(Object object) {

        StringBuilder builder = new StringBuilder();

        // convert the value into a JSON value.
        try {
            if (object != null) {
                String objectJson = mapper.writeValueAsString(object);

                // construct the header part.
                builder.append(String.format("Content-Length: %d\r\n", objectJson.length()));
                builder.append("Content-Type: utf-8\r\n");

                // construct the content part.
                builder.append("\r\n");
                builder.append("{");
                builder.append(objectJson);
                builder.append("}");

                return Optional.of(builder.toString());
            } else {
                return Optional.empty();
            }
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

    // TODO: implement the decoding later.

}

