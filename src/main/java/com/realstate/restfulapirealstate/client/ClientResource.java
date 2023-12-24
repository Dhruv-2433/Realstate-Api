package com.realstate.restfulapirealstate.client;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class ClientResource {

	private ClientDaoService service;
	
	public ClientResource(ClientDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/client")
	public List<Client> retriveAllClients(){
		return service.findAll();
	}
	
	@GetMapping("/client/{id}")
	public Client retriveClients(@PathVariable int id){
	
		Client client = service.findOne(id);
		
		if(client==null)
			throw new ClientNotFoundExecption("id:"+id);
		
		return client;
	}
	
	@DeleteMapping("/client/{id}")
	public void deleteClient(@PathVariable int id){
	
		service.deleteByClient(id);
	}
	
	@PostMapping("/client")
	public ResponseEntity<Client> newClient(@Valid @RequestBody Client client) {
		
		Client savedClient = service.save(client);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedClient.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
