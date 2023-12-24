package com.realstate.restfulapirealstate.employee;

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
public class EmployeeResource {

	private EmployeeDaoService service;
	
	public EmployeeResource(EmployeeDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/employee")
	public List<Employee> retriveAllEmployees(){
		return service.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee retriveEmployees(@PathVariable int id){
		
		Employee employee = service.findOne(id);
		
		if(employee == null)
			throw new EmployeeNotFoundExecption("id:"+id);
		
		return employee;
		
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id){
	
		service.deleteByEmployee(id);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee = service.save(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedEmployee.getEmployee_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
