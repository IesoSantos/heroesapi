package com.ieso.heroesapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ieso.heroesapi.repository.HeroesRepository;
import static com.ieso.heroesapi.constants.HeroesConstants.HEREOES_ENDPOINT_LOCAL;
@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesapiApplicationTests {
	
	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	HeroesRepository heroesRepository;

	@Test
	public void getOneHeroById() {
		webTestClient.get().uri(HEREOES_ENDPOINT_LOCAL.concat("/{id}"),"10")
		.exchange()
		.expectStatus().isOk()
		.expectBody();
	}
	
	@Test
	public void getOneHeroNotFound() {
		webTestClient.get().uri(HEREOES_ENDPOINT_LOCAL.concat("/{id}"),"10")
		.exchange()
		.expectStatus().isNotFound();
	}

}
