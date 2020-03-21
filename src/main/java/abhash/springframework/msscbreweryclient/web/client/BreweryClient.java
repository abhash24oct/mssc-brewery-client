package abhash.springframework.msscbreweryclient.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import abhash.springframework.msscbreweryclient.web.model.BeerDto;

@Controller
@ConfigurationProperties(value="sfg.brewery",ignoreUnknownFields =false)
public class BreweryClient {
	
	public final String BEER_PATH_V1="/api/v1/beer/";
	private String apihost;
	private RestTemplate restTemplate;
	
	
	//Injected by spring
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	
	//Injected by spring
	public void setApihost(String apihost) {
		this.apihost = apihost;
	}

	public BeerDto getBeerById(UUID beerId) {
		return restTemplate.getForObject(apihost+""+BEER_PATH_V1+""+beerId.toString(), BeerDto.class);
	}



}
