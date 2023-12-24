package com.realstate.restfulapirealstate.property;

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
public class PropertyResource {

	private PropertyDaoService service;
	
	public PropertyResource(PropertyDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/property")
	public List<Property> retriveAllPropertys(){
		return service.findAll();
	}
	
	@GetMapping("/property/{id}")
	public Property retriveProperty(@PathVariable int id){
	
		Property property = service.findOne(id);
		
		if(property == null)
			throw new PropertyNotFoundExecption("id:"+id);
		
		return property;
			
	}
	
	@DeleteMapping("/property/{id}")
	public void deleteProperty(@PathVariable int id){
	
		service.deleteByProperty(id);
	}
	
	
	@PostMapping("/property")
	public ResponseEntity<Property> newProperty(@RequestBody Property property) {
		
		Property savedProperty = service.save(property);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedProperty.getProperty_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
