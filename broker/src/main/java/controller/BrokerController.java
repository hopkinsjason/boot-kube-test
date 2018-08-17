package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import player.transport.PlayerDTO;
import player.transport.client.PlayerServiceClient;
import player.transport.client.PlayerServiceClientImpl;

@Controller
public class BrokerController {

	private PlayerServiceClient playerService;
	
	public BrokerController(@Value("${player.service.url}") String playerServiceURL) {
		System.out.println("Player Service URL:" + playerServiceURL);
		playerService = new PlayerServiceClientImpl(playerServiceURL);
	}
	
	@GetMapping("/")
	public String home(Model model) throws Exception {
		
		addHomeAttributes(model);
		return "home";
	}
	
	@PostMapping("/createPlayer")
	public String createPlayer(@ModelAttribute(name="newPlayer") PlayerDTO player, Model model) throws Exception {
		
		playerService.createPlayer(player);
		addHomeAttributes(model);
		
		return "home";
	}
	
	private void addHomeAttributes(Model model) throws Exception {

		String namespace = System.getenv("NAMESPACE");
		String pod = System.getenv("HOSTNAME");
		
		if (namespace != null && !namespace.isEmpty()) {
			namespace = "Default";
		}
		
		String environment = "Outside Kubernetes!";
		
		if (pod != null && !pod.isEmpty()) {
			environment = namespace + " - " + pod;
		}
		
		List<PlayerDTO> allPlayers = playerService.allPlayers();
		PlayerDTO newPlayer = new PlayerDTO();
		model.addAttribute("environment", environment);
		model.addAttribute("newPlayer", newPlayer);
		model.addAttribute("playerList", allPlayers);		
		
		
	}
	
}
