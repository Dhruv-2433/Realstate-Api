package com.realstate.restfulapirealstate.property;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class PropertyDaoService {
	
	private static List<Property> propertys = new ArrayList<>();
	
	private static int propertyCount = 600;

	static {
		propertys.add(new Property(++propertyCount,"Flat","Olive Greens Gota","Ahmedabad",400001,5000000));
		propertys.add(new Property(++propertyCount,"Tenament","Stanza Living","Surat",110001,12000000));
		propertys.add(new Property(++propertyCount,"House","Sector-22","Gandhinagar",560001,8000000));
		propertys.add(new Property(++propertyCount,"Flat","Satvam","Vadodara",600001,6000000));
		propertys.add(new Property(++propertyCount,"Vila","104,CG Road","Ahmedabad",500001,70000000));
	}
	
	List<Property>findAll(){
		return propertys;
	}
	
	public Property save(Property property) {
		property.setProperty_id(++propertyCount);
		propertys.add(property);
		return property;
	}
	
	public Property findOne(int id) {
		Predicate<? super Property> predicate = property -> property.getProperty_id().equals(id);
		return propertys.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteByProperty(int id) {
		Predicate<? super Property> predicate = property -> property.getProperty_id().equals(id);
		propertys.removeIf(predicate);
	}
}
