package com.realstate.restfulapirealstate.broker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
//@Table(name = "broker")
public class Broker {
	
	protected Broker() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer broker_id;
	private String broker_name;
	private String broker_email;
	private Integer broker_number;
	private Integer broker_comission;

	public Integer getBroker_id() {
		return broker_id;
	}

	public void setBroker_id(Integer broker_id) {
		this.broker_id = broker_id;
	}

	public String getBroker_name() {
		return broker_name;
	}

	public void setBroker_name(String broker_name) {
		this.broker_name = broker_name;
	}

	public String getBroker_email() {
		return broker_email;
	}

	public void setBroker_email(String broker_email) {
		this.broker_email = broker_email;
	}

	public Integer getBroker_number() {
		return broker_number;
	}

	public void setBroker_number(Integer broker_number) {
		this.broker_number = broker_number;
	}

	public Integer getBroker_comission() {
		return broker_comission;
	}

	public void setBroker_comission(Integer broker_comission) {
		this.broker_comission = broker_comission;
	}

	public Broker(Integer broker_id, String broker_name, String broker_email, Integer broker_number,
			Integer broker_comission) {
		super();
		this.broker_id = broker_id;
		this.broker_name = broker_name;
		this.broker_email = broker_email;
		this.broker_number = broker_number;
		this.broker_comission = broker_comission;
	}

	@Override
	public String toString() {
		return "Broker [broker_id=" + broker_id + ", broker_name=" + broker_name + ", broker_email=" + broker_email
				+ ", broker_number=" + broker_number + ", broker_comission=" + broker_comission + "]";
	}

}
