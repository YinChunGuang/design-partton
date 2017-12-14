package com.chun.design.d04_proxy.e3;

public class UserDao{

	/**
	 * 没有开启事物
	 */
	public void insert(User t) {
		
		System.out.println( "save user succcess");
		
	}
	/**
	 * 没有开启事物
	 */
	public void add(User t) {
		
		System.out.println( "add user succcess");
		
	}
	/**
	 * 没有开启事物
	 */
	public void delete(User t) {
		
		System.out.println( "delete user succcess");
		
	}
	

}
