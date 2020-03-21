package abhash.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
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
	
	@Test
	void testSaveBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("Leffe").id(UUID.randomUUID()).build();
		
		URI uri = beerCleint.saveBeer(beerDto);
		System.out.println(uri);
		assertNotNull(uri);
	}
	
	@Test
	void testUpdateBeer() {
		
		beerCleint.updateBeer(UUID.randomUUID(), BeerDto.builder()
													.beerName("Duvel")
													.build());
	}
	
	@Test
	void testDeleteBeer() {
		
		beerCleint.deleteBeer(UUID.randomUUID());
	}

}
