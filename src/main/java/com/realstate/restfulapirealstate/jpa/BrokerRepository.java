package com.realstate.restfulapirealstate.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realstate.restfulapirealstate.broker.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Integer>{

}
