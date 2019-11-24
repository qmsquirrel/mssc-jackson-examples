package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class KebabTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testKebab() throws JsonProcessingException {
        BeerDto dto = getDto();

        String json =objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }

}
