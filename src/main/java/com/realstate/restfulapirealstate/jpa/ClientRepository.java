package com.realstate.restfulapirealstate.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realstate.restfulapirealstate.client.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
