package com.chun.design.d04_proxy.e3;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserProxy implements MethodInterceptor{
	private Object target;
	public UserProxy(Object obj) {
		target = obj;
	}
	
	public Object getProxyInstance() {
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		
		return en.create();
	}
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        System.out.println("提交事务...");

        return returnValue;
	}
	 
	 
}
