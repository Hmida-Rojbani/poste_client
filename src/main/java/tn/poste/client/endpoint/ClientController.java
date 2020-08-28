package tn.poste.client.endpoint;

import org.springframework.beans.factory.annotation.Value;
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
@AllArgsConstructor()
public class ClientController {
	
	private ClientService clientService;
	
	@Value("${error.message}")
	private static String errorMessage;

	@GetMapping()
	public String getAllProduct(Model model) {

		model.addAttribute("listClients", clientService.getAllClient());

		return "client/list_client";
	};
	
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
	
	// add display all 
	// add a template contain table all client
	
	@PostMapping("/add")
	public String addClient(@ModelAttribute("client") ClientDto clientDto, Model model) {
		System.err.println(clientDto);
		try {
			if (clientDto.checkAllNotNull()) {
				clientService.saveClient(clientDto);
				return "redirect:/clients";
			}
		} catch (IllegalAccessException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "client/add_client";
		}
		return "redirect:/clients/add";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduitById(@PathVariable int id) {
		clientService.deleteClientById(id);
		return "redirect:/clients";
		
	}

}
