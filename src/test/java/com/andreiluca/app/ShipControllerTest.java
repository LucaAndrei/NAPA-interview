package com.andreiluca.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import com.andreiluca.app.model.Ship;
import com.andreiluca.app.repository.ShipRepository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShipControllerTest {


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private Ship ship;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {

        this.shipRepository.deleteAllInBatch();
        this.ship = shipRepository.save(new Ship("myTestShip", "myTestClass", 1000, 1000, (float)100.0, 10.0f, 2017,
        		false, "Romania", 45.0f, 45.0f));
    }

    @Test
    public void testA() throws Exception {
    	Ship testShip2 = new Ship("myTestShip2", "myTestClass2", 2000, 2000, 200.0f, 20.0f, 2017,
        		false, "Romania", 25.0f, 25.0f);
        String shipJson = json(testShip2);
        this.mockMvc.perform(post("/ships")
                .contentType(contentType)
                .content(shipJson))
                .andExpect(status().is2xxSuccessful());
        
    }
    @Test
    public void testB() throws Exception {
    	assertThat(mockMvc).isNotNull();
        this.mockMvc.perform(get("/ships"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)))      
                .andExpect(jsonPath("$[0].id", is(this.ship.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(this.ship.getName())))
                .andExpect(jsonPath("$[0].tonnage", is(this.ship.getTonnage())))
                .andExpect(jsonPath("$[0].country", is(this.ship.getCountry())))
                .andExpect(jsonPath("$[0].active", is(this.ship.isActive())))
                .andExpect(jsonPath("$[0].shipClass", is(this.ship.getShipClass())))
                .andExpect(jsonPath("$[0].grossTonnage", is(this.ship.getGrossTonnage())));
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}