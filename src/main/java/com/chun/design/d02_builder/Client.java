package com.chun.design.d02_builder;

public class Client {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConcreateBuilder concreateBuilder = new ConcreateBuilder();
		Director director = new Director();
		director.getProduct(concreateBuilder);
		Product product = concreateBuilder.getProduct();
		
		
	}
}
