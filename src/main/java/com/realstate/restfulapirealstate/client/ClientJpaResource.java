package com.realstate.restfulapirealstate.client;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.realstate.restfulapirealstate.jpa.ClientRepository;

import jakarta.validation.Valid;

@RestController
public class ClientJpaResource {
	
	private ClientRepository repository;
	
	public ClientJpaResource(ClientRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/jpa/client")
	public List<Client> retriveAllClients(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/client/{id}")
	public Optional<Client> retriveClients(@PathVariable int id){
	
		Optional<Client> client = repository.findById(id);
		
		if(client.isEmpty())
			throw new ClientNotFoundExecption("id:"+id);
		
		return client;
	}
	
	@DeleteMapping("/jpa/client/{id}")
	public void deleteClient(@PathVariable int id){
	
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/client")
	public ResponseEntity<Client> newClient(@Valid @RequestBody Client client) {
		
		Client savedClient = repository.save(client);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedClient.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
