package com.realstate.restfulapirealstate.employee;

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

import com.realstate.restfulapirealstate.jpa.EmployeeRepository;

@RestController
public class EmployeeJpaResource {
	
	private EmployeeRepository repository;
	
	public EmployeeJpaResource(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/jpa/employee")
	public List<Employee> retriveAllEmployees(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/employee/{id}")
	public Optional<Employee> retriveEmployees(@PathVariable int id){
		
		Optional<Employee> employee = repository.findById(id);
		
		if(employee == null)
			throw new EmployeeNotFoundExecption("id:"+id);
		
		return employee;
		
	}
	
	@DeleteMapping("/jpa/employee/{id}")
	public void deleteEmployee(@PathVariable int id){
	
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/employee")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee = repository.save(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedEmployee.getEmployee_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
