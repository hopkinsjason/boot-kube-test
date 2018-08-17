package player.transport.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import player.transport.PlayerDTO;

public class PlayerServiceClientImpl implements PlayerServiceClient {

	private String playerServiceURL;

	private RestTemplate restTemplate;
	
	public PlayerServiceClientImpl(String url) {
		playerServiceURL = url;
		restTemplate = new RestTemplate();
	}
	
	public List<PlayerDTO> allPlayers() throws Exception {
		return restTemplate.exchange(
				playerServiceURL + "/player/", 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<PlayerDTO>>() {}).getBody();
		
	}
	
	@Override
	public void createPlayer(PlayerDTO playerDTO) throws Exception {
		restTemplate.postForObject(playerServiceURL + "/player/", playerDTO, Void.class);
	}
}
