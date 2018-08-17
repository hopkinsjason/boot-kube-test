package playerservice.repository;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import playerservice.model.Player;
import playerservice.repository.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerRepositoryTest {

	@Autowired
	PlayerRepository playerRepository;
	
	@Test
	public void testSavePlayer() {
		Player player = new Player("TestPlayer");
		
		player = playerRepository.save(player);
		
		assertThat(playerRepository.findById(player.getUsername())).isPresent();
	}
	
}
