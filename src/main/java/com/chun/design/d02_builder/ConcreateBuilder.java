package com.chun.design.d02_builder;

public class ConcreateBuilder extends Builder {

	Product product = new Product();
	@Override
	public void buildA() {
		System.out.println("build A");
		product.buildA();
	}

	@Override
	public void buildB() {
		product.buildB(); 
		System.out.println("build B");
	}
	@Override
	public void buildC() {
		// TODO Auto-generated method stub
		System.out.println("build C");
		product.buildC();
	}

	@Override
	public Product getProduct() {
		 
		return product;
	}


	
}
