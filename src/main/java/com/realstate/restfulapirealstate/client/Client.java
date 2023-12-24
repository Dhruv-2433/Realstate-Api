package com.realstate.restfulapirealstate.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	protected Client() {
		
	}

	@Id
	@GeneratedValue
	private Integer client_id;
	private String client_name;
	private String client_email;
	private Integer client_number;	
	private Integer client_budget;

	public Client(Integer id, String name, String email, Integer number, Integer budget) {
		super();
		this.client_id = id;
		this.client_name = name;
		this.client_email = email;
		this.client_number = number;
		this.client_budget = budget;
	}

	public Integer getId() {
		return client_id;
	}

	public void setId(Integer id) {
		this.client_id = id;
	}

	public String getName() {
		return client_name;
	}

	public void setName(String name) {
		this.client_name = name;
	}

	public String getEmail() {
		return client_email;
	}

	public void setEmail(String email) {
		this.client_email = email;
	}

	public Integer getNumber() {
		return client_number;
	}

	public void setNumber(Integer number) {
		this.client_number = number;
	}

	public Integer getBudget() {
		return client_budget;
	}

	public void setBudget(Integer budget) {
		this.client_budget = budget;
	}

	@Override
	public String toString() {
		return "Client [id=" + client_id + ", name=" + client_name + ", email=" + client_email + ", number=" + client_number + ", budget=" + client_budget
				+ "]";
	}

}
