package tn.poste.client.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.client.data.entities.Client;

public interface ClientRepos extends JpaRepository<Client, Integer>{

}
