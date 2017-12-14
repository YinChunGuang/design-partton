
package com.chun.design.d04_proxy.e1;
/**
 * 
 * 静态代理
 */
public class Clinet {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();
		UserProxy userProxy = new UserProxy(userDao);
		User user = new User();
		userProxy.insert(user);
	}
}
