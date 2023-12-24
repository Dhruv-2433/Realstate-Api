package com.realstate.restfulapirealstate.property;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Property {
	
	protected Property() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer property_id;
	private String property_type;
	private String address;
	private String city;
	private Integer pincode;
	private Integer price;
	
	@OneToMany(mappedBy = "property")
	@JsonIgnore
	private List<PropertyInfo> propertyInfo;

	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Property(Integer property_id, String property_type, String address, String city, Integer pincode,
			Integer price) {
		super();
		this.property_id = property_id;
		this.property_type = property_type;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", property_type=" + property_type + ", address=" + address
				+ ", city=" + city + ", pincode=" + pincode + ", price=" + price + "]";
	}

	public List<PropertyInfo> getPropertyInfo() {
		return propertyInfo;
	}

	public void setPropertyInfo(List<PropertyInfo> propertyInfo) {
		this.propertyInfo = propertyInfo;
	}

}
