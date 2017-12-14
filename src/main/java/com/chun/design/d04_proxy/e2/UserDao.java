package com.chun.design.d04_proxy.e2;

public class UserDao implements Dao<User> {

	/**
	 * 没有开启事物
	 */
	@Override
	public void insert(User t) {
		
		System.out.println( "save user succcess");
		
	}

}
