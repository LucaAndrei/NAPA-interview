package com.andreiluca.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.andreiluca.app.controller.ShipController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
    private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test_getShips() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ships", List.class)).isNotEmpty();
	}

}
