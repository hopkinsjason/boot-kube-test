package playerservice.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import player.transport.PlayerDTO;
import playerservice.model.Player;
import playerservice.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Transactional
	public void addPlayer(Player player) {
		checkNotNull(player, "PlayerDTO cannot be null while creating a player");
		checkNotNull(player.getUsername(), "Username of the player cannot be null");
		
		playerRepository.save(player);
	}
	
	public List<Player> all() {
		return ImmutableList.copyOf(playerRepository.findAll());
	}
	
	public List<Player> playersByUsername(String username) {
		checkNotNull(username, "Cannot search for a null username");
		
		return playerRepository.findByUsername(username);
		
	}
	
	
	
}
