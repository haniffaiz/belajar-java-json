package programmerzamannow.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;


public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName","Hanif",
                "lastName","Faiz",
                "age",26,
                "married",false,
                "address", Map.of(
                        "street","Jalan belum ada",
                        "city","Jakarta",
                        "country","Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {"age":26,"married":false,"lastName":"Faiz","firstName":"Hanif","address":{"country":"Indonesia","city":"Jakarta","street":"Jalan belum ada"}}
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {


        });

        Assertions.assertEquals("Hanif", person.get("firstName"));
        Assertions.assertEquals("Faiz", person.get("lastName"));
    }
}
