package tn.poste.client.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.client.data.dto.ClientDto;
import tn.poste.client.data.entities.Client;
import tn.poste.client.data.repos.ClientRepos;
import tn.poste.client.errors.ClientNotFoundException;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepos clientRepos;
	private ModelMapper mapper;
	
	public ClientDto getClientById(int id) {
		Client client = clientRepos.findById(id).orElseThrow(()-> new ClientNotFoundException("Client with this id is not found"));
		return mapper.map(client, ClientDto.class);
	}
	
	public List<ClientDto> getAllClient() {
		List<Client> clients = clientRepos.findAll();
		return clients.stream()
				.map(client -> mapper.map(client, ClientDto.class))
				.collect(Collectors.toList());
	}
	
	public String saveClient(ClientDto clientDto) {
		Client client = mapper.map(clientDto, Client.class);
		client = clientRepos.save(client);
		return "Client is Saved";
	}

}
