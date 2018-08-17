package playerservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import player.transport.PlayerDTO;
import playerservice.model.Player;
import playerservice.service.PlayerService;

@RequestMapping("/player")
@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody PlayerDTO addPlayer(@RequestBody PlayerDTO playerDTO) {
		playerService.addPlayer(new Player(playerDTO.getUsername()));
		return playerDTO;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody List<PlayerDTO> players() {
		return playerService.all()
				.stream()
				.map(p -> new PlayerDTO(p.getUsername()))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public @ResponseBody List<PlayerDTO> playersByUsername(@PathVariable String username) {
		return playerService.playersByUsername(username)
				.stream()
				.map(p -> new PlayerDTO(p.getUsername()))
				.collect(Collectors.toList());
	}
	
}
