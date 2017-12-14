
package com.chun.design.d04_proxy.e2;


/**
 * JDK
 */
public class Clinet {

	public static void main(String[] args) {
		
		final UserDao userDao = new UserDao();
		final User user = new User();
		UserProxy userProxy = new UserProxy(userDao);
		userProxy.operate(user);
		
		
	}
}
