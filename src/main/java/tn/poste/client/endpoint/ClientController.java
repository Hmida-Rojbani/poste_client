package tn.poste.client.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import tn.poste.client.data.dto.ClientDto;
import tn.poste.client.services.ClientService;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
	
	private ClientService clientService;
	
	
	@GetMapping("/add")
	public String getAddClient(Model model) {
		model.addAttribute("client", new ClientDto());
		return "client/add_client";
	}
	
	@GetMapping("/id/{id}")
	public String getClientById(@PathVariable("id") int id, Model model) {
		ClientDto client = clientService.getClientById(id);
		model.addAttribute("client", client);
		return "client/get_client";
	}
	
	
	
	@PostMapping("/add")
	public String addClient(@ModelAttribute("client") ClientDto clientDto) {
		clientService.saveClient(clientDto);
		return "index";
		
	}

}
