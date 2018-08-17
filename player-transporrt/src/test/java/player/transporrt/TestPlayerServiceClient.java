package player.transporrt;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import player.transport.PlayerDTO;
import player.transport.client.PlayerServiceClient;
import player.transport.client.PlayerServiceClientImpl;

@Ignore
public class TestPlayerServiceClient {

	@Test
	public void testAllPlayers() throws Exception {
		PlayerServiceClient client = new PlayerServiceClientImpl("http://localhost:8080");
		List<PlayerDTO> players = client.allPlayers();
		
		System.out.println("Called player service:");
		players.stream().forEach(System.out::println);
	}

	@Test
	public void testCreatePlayer() throws Exception {
		PlayerServiceClient client = new PlayerServiceClientImpl("http://localhost:8080");
		client.createPlayer(new PlayerDTO("Troy"));
		List<PlayerDTO> players = client.allPlayers();
		players.stream().forEach(System.out::println);
	}
	
}
