package com.realstate.restfulapirealstate.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class ClientDaoService {
	
	private static List<Client> clients = new ArrayList<>();
	
	private static int clientCount = 300;
	static {
		clients.add(new Client(++clientCount,"Ridham","ridham@gmail.com",942883571,5000000));
		clients.add(new Client(++clientCount,"Dhruvil","dhruvil@gmail.com",921324321,9000000));
		clients.add(new Client(++clientCount,"Arjun","arjun@gmail.com",984124444,50000000));
		clients.add(new Client(++clientCount,"Ravi","ravi@gmail.com",741256992,15000000));
		clients.add(new Client(++clientCount,"Umang","umang@gmail.com",758963214,6500000));
	}
	
	List<Client>findAll(){
		return clients;
	}
	
	public Client save(Client client) {
		client.setId(++clientCount);
		clients.add(client);
		return client;
	}
	
	public Client findOne(int id) {
		Predicate<? super Client> predicate = client -> client.getId().equals(id);
		return clients.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteByClient(int id) {
		Predicate<? super Client> predicate = client -> client.getId().equals(id);
		clients.removeIf(predicate);
	}
}
