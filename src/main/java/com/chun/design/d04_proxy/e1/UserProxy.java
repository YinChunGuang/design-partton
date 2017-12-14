package com.chun.design.d04_proxy.e1;


public class UserProxy implements Dao<User>{

	private Dao dao ; 
	public  UserProxy(Dao<User> dao) {
		this.dao = dao;
	}
	@Override
	public void insert(User t) {
		
		// start transation
		System.out.println("start transaction");
		dao.insert(t);
		System.out.println("commit transaction");
		// commit 
		
	}
	

}
