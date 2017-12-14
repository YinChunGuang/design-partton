package com.chun.design.d04_proxy;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ConcretePrototype concretePrototype = new ConcretePrototype();
		concretePrototype.setAge(10);
		concretePrototype.setName("lili");
		List<String> listValues = new ArrayList<>();
		listValues.add("lili");
		listValues.add("liming");
		
		concretePrototype.setValueList(listValues);
		
		
		ConcretePrototype clone = (ConcretePrototype)concretePrototype.clone();
		
		List<String> valueList = clone.getValueList();
		System.out.println(valueList.equals(listValues));
	}

}
