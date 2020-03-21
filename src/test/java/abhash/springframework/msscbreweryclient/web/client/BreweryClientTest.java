package abhash.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import abhash.springframework.msscbreweryclient.web.model.BeerDto;


@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient beerCleint;

	@Test
	void testGetBeerById() {
		BeerDto beeDto = beerCleint.getBeerById(UUID.randomUUID());
		assertNotNull(beeDto);
	}

}
