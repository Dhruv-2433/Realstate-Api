package com.realstate.restfulapirealstate.employee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "employee_details")
//@Table(name = "employee_details")
public class Employee {

	protected Employee() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer employee_id;
	private String employee_name;
	private String employee_email;
	private Integer employee_number;
	private Integer employee_salary;
	private String employee_position;

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public Integer getEmployee_number() {
		return employee_number;
	}

	public void setEmployee_number(Integer employee_number) {
		this.employee_number = employee_number;
	}

	public Integer getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(Integer employee_salary) {
		this.employee_salary = employee_salary;
	}

	public String getEmployee_position() {
		return employee_position;
	}

	public void setEmployee_position(String employee_position) {
		this.employee_position = employee_position;
	}

	public Employee(Integer employee_id, String employee_name, String employee_email, Integer employee_number,
			Integer employee_salary, String employee_position) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_email = employee_email;
		this.employee_number = employee_number;
		this.employee_salary = employee_salary;
		this.employee_position = employee_position;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_email="
				+ employee_email + ", employee_number=" + employee_number + ", employee_salary=" + employee_salary
				+ ", employee_position=" + employee_position + "]";
	}

}
