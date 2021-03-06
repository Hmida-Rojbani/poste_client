package tn.poste.client.rest.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.poste.client.data.dto.ClientDto;
import tn.poste.client.services.ClientService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientRestController {
	
	private ClientService clientService;
	
	@GetMapping("/all")
	public List<ClientDto> getAll(){
		return clientService.getAllClient();
	}
	
	@GetMapping("/id/{id}")
	public ClientDto getId(@PathVariable("id") int id){
		return clientService.getClientById(id);
	}
	
	@PostMapping("/save")
	public String createClient(@Valid @RequestBody ClientDto clientDto){
		return clientService.saveClient(clientDto);
	}
	
	// a faire
	@PutMapping("/update/{id}")
	public ClientDto updateClient(@PathVariable("id") int id, @Valid @RequestBody ClientDto clientDto){
		return clientService.updateClient(id, clientDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ClientDto deleteClient(@PathVariable("id") int id){
		return clientService.deleteClientById(id);
	}

}
