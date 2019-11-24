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
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123456789,\"price\":\"12.99\",\"createdDate\":\"2019-11-24T19:10:24+0100\",\"lastUpdatedDate\":\"2019-11-24T19:10:24.8777492+01:00\",\"myLocalDate\":\"20191124\",\"beerId\":\"105deaaa-6f00-4c0e-a97b-4192490d77c0\"}\n";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }
}