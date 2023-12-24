package com.realstate.restfulapirealstate.property;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
//@Table(name = "property_info")
public class PropertyInfo {

	@Id
	@GeneratedValue
	private Integer property_id;

	private String fetures;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Property property;

	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	public String getFetures() {
		return fetures;
	}

	public void setFetures(String fetures) {
		this.fetures = fetures;
	}

	@Override
	public String toString() {
		return "PropertyInfo [property_id=" + property_id + ", fetures=" + fetures + "]";
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}
