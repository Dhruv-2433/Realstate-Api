package com.realstate.restfulapirealstate.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realstate.restfulapirealstate.property.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer>{

}
