package com.realstate.restfulapirealstate.broker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class BrokerDaoService {

		public static List<Broker> brokers = new ArrayList<>();

		private static int brokerCount = 200;

		static {
			brokers.add(new Broker(++brokerCount,"Parth","parth@gmail.com",981563204,6));
			brokers.add(new Broker(++brokerCount,"Janki","janki@gmail.com",975218080,10));
			brokers.add(new Broker(++brokerCount,"Vishal","vishal@gmail.com",994938928,8));
			brokers.add(new Broker(++brokerCount,"Jaimin","jaimin@gmail.com",912858580,7));
			brokers.add(new Broker(++brokerCount,"Krunal","krunal@gmail.com",920891893,8));
		}
		
		List<Broker> findAll(){
			return brokers;
		}
		
		public Broker save(Broker broker) {
			broker.setBroker_id(++brokerCount);
			brokers.add(broker);
			return broker;
		}
		
		public Broker findOne(int id) {
			Predicate<? super Broker> predicate = broker -> broker.getBroker_id().equals(id);
			return brokers.stream().filter(predicate).findFirst().orElse(null);
		}
		
		public void deleteByBroker(int id) {
			Predicate<? super Broker> predicate = broker -> broker.getBroker_id().equals(id);
			brokers.removeIf(predicate);
		}
}