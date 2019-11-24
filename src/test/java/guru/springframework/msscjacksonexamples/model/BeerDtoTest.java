package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    public void testDeserialize() throws IOException {
        String json = "{\"id\":\"3bf8ab69-1c76-4197-a522-33493ee10b3d\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123456789,\"price\":12.99,\"createdDate\":\"2019-11-24T18:14:26.472621+01:00\",\"lastUpdatedDate\":null}\n";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }
}