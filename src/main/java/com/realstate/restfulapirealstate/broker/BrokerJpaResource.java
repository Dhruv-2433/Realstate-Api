package com.realstate.restfulapirealstate.broker;

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

import com.realstate.restfulapirealstate.jpa.BrokerRepository;

@RestController
public class BrokerJpaResource {
	
	private BrokerRepository repository;
	
	public BrokerJpaResource(BrokerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/jpa/broker")
	public List<Broker> retriveAllBrokers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/broker/{id}")
	public Optional<Broker> retriveBrokers(@PathVariable int id){
	
		Optional<Broker> broker = repository.findById(id);
		
		if(broker.isEmpty())
			throw new BrokerNotFoundExecption("id:"+id);
		
		return broker;
		
	}
	
	@DeleteMapping("/jpa/broker/{id}")
	public void deleteBroker(@PathVariable int id){
	
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/broker")
	public ResponseEntity<Broker> newBroker(@RequestBody Broker broker) {
		
		Broker savedBroker = repository.save(broker);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedBroker.getBroker_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
