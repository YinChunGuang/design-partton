package com.chun.design.d04_proxy.e2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy {
	private Dao dao;
	public UserProxy() {
		
	}
	public UserProxy(Dao dao) {
		this.dao = dao;
	}

	
	private <T> Dao<T> getInstance() {
		
		Object newProxyInstance = Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("start ");
				
				method.invoke(dao, args);
				
				System.out.println("end ");
				return proxy;
			}
		});
		return (Dao<T>)newProxyInstance;
	}
	
	public <T> void operate(T t){
		getInstance().insert(t);
	}
}
