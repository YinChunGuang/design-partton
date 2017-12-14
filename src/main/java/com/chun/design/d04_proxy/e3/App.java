package com.chun.design.d04_proxy.e3;
public class App {

 
    /**
     * 
		 在Spring的AOP编程中:
		如果加入容器的目标对象有实现接口,用JDK代理
		如果目标对象没有实现接口,用Cglib代理
		
     * @param args
     */
    public static void main(String[] args) {
    	  UserDao target = new UserDao();

          //代理对象
          UserDao proxy = (UserDao)new UserProxy(target).getProxyInstance();

          User t = new User();
          //执行代理对象的方法
          proxy.delete(t);
	}
}