package com.realstate.restfulapirealstate.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoService {
	
private static List<Employee> employees = new ArrayList<>();
	
	private static int employeeCount = 100;
	static {
		employees.add(new Employee(++employeeCount,"Rajesh","rajesh@gmail.com",987654321,75000,"Manager"));
		employees.add(new Employee(++employeeCount,"Priya","priya@gmail.com",921326321,50000,"Hr"));
		employees.add(new Employee(++employeeCount,"Amit","amit@gmail.com",984123333,60000,"Accountant"));
		employees.add(new Employee(++employeeCount,"Shreya","shreya@gmail.com",984468921,40000,"Employee"));
		employees.add(new Employee(++employeeCount,"kency","kency@gmail.com",986248109,45000,"Employee"));
	}
	
	List<Employee>findAll(){
		return employees;
	}
	
	public Employee save(Employee employee) {
		employee.setEmployee_id(++employeeCount);
		employees.add(employee);
		return employee;
	}
	
	public Employee findOne(int id) {
		Predicate<? super Employee> predicate = employee -> employee.getEmployee_id().equals(id);
		return employees.stream().filter(predicate).findFirst().orElse(null);
	}
	public void deleteByEmployee(int id) {
		Predicate<? super Employee> predicate = employee -> employee.getEmployee_id().equals(id);
		employees.removeIf(predicate);
	}
}