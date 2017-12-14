package com.chun.design.d02_builder;

public class Director {
 
 
	public void getProduct(ConcreateBuilder concreateBuilder) {
		concreateBuilder.buildA();
		concreateBuilder.buildB();
		concreateBuilder.buildC();
	}
	
}
