package player.transport.client;

import java.util.List;

import player.transport.PlayerDTO;

public interface PlayerServiceClient {
	
	public List<PlayerDTO> allPlayers() throws Exception;

	public void createPlayer(PlayerDTO playerDTO) throws Exception;
}
