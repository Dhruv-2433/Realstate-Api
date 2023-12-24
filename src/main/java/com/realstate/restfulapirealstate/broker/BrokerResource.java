package com.realstate.restfulapirealstate.broker;

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

@RestController
public class BrokerResource {

	private BrokerDaoService service;
	
	public BrokerResource(BrokerDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/broker")
	public List<Broker> retriveAllBrokers(){
		return service.findAll();
	}
	
	@GetMapping("/broker/{id}")
	public Broker retriveBrokers(@PathVariable int id){
	
		Broker broker = service.findOne(id);
		
		if(broker==null)
			throw new BrokerNotFoundExecption("id:"+id);
		
		return broker;
		
	}
	
	@DeleteMapping("/broker/{id}")
	public void deleteBroker(@PathVariable int id){
	
		service.deleteByBroker(id);
	}
	
	@PostMapping("/broker")
	public ResponseEntity<Broker> newBroker(@RequestBody Broker broker) {
		
		Broker savedBroker = service.save(broker);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedBroker.getBroker_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
