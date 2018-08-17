package playerservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import player.transport.PlayerDTO;
import playerservice.model.Player;
import playerservice.service.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlayerService {

	@Autowired
	PlayerService playerService;
	
	@Test(expected=NullPointerException.class)
	public void testAddPlayerNullPlayer() {
		playerService.addPlayer(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddPlayerNullUsername() {
		playerService.addPlayer(new Player());
	}
	
	@Test
	public void testAddPlayer() {
		playerService.addPlayer(new Player("player_service_test"));
		
		assertThat(playerService.playersByUsername("player_service_test")).hasSize(1);
	}

	@Test
	public void testFindPlayerByUsername() {
		playerService.addPlayer(new Player("player_service_test"));
		playerService.addPlayer(new Player("player_service_test1"));
		
		assertThat(playerService.playersByUsername("player_service_test")).hasSize(2);
	}
}
