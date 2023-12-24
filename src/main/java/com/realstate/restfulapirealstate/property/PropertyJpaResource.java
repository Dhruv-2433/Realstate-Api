package com.realstate.restfulapirealstate.property;

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

import com.realstate.restfulapirealstate.jpa.PropertyInfoRepository;
import com.realstate.restfulapirealstate.jpa.PropertyRepository;

@RestController
public class PropertyJpaResource {

	private PropertyRepository repository;
	private PropertyInfoRepository propertyInfoRepository;
	
	public PropertyJpaResource(PropertyRepository repository,PropertyInfoRepository propertyInfoRepository) {
		this.repository = repository;
		this.propertyInfoRepository = propertyInfoRepository;
	}
	
	@GetMapping("/jpa/property")
	public List<Property> retriveAllPropertys(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/property/{id}")
	public Optional<Property> retriveProperty(@PathVariable int id){
	
		Optional<Property> property = repository.findById(id);
		
		if(property == null)
			throw new PropertyNotFoundExecption("id:"+id);
		
		return property;
			
	}
	
	@DeleteMapping("/jpa/property/{id}")
	public void deleteProperty(@PathVariable int id){
	
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/property/{id}/info")
	public List<PropertyInfo> retriveFeatureForProperty(@PathVariable int id){
	
		Optional<Property> property = repository.findById(id);
		
		if(property == null)
			throw new PropertyNotFoundExecption("id:"+id);
		
		return property.get().getPropertyInfo();
	}
	
	
	@PostMapping("/jpa/property")
	public ResponseEntity<Property> newProperty(@RequestBody Property property) {
		
		Property savedProperty = repository.save(property);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedProperty.getProperty_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/jpa/property/{id}/info")
	public ResponseEntity<Object> CreateFeatureForProperty(@PathVariable int id,@RequestBody PropertyInfo propertyInfo){
	
		Optional<Property> property = repository.findById(id);
		
		if(property == null)
			throw new PropertyNotFoundExecption("id:"+id);
		
		propertyInfo.setProperty(property.get());
		
		PropertyInfo savedPropertyInfo = propertyInfoRepository.save(propertyInfo);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPropertyInfo.getProperty_id())
				.toUri();
		
		return ResponseEntity.created(location).build();	}
}
