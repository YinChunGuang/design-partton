package com.chun.netty.client.e1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.language.Metaphone;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.chun.netty.client.annation.RemoteInvoke;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 属性注入之前
 * @author yinchunguang
 *
 */
@Component
public class InitInvoke implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		Field[] fields = bean.getClass().getDeclaredFields();
		for(Field field : fields) {
			if (field.isAnnotationPresent(RemoteInvoke.class)) {
				field.setAccessible(true);
				
				Enhancer enhancer = new Enhancer();
				enhancer.setInterfaces(new Class[] {field.getType()});
				Map<Method,String> methodMap = new HashMap<>();
				
				final String className = field.getType().getName();
				enhancer.setCallback(new MethodInterceptor() {
					
					@Override
					public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
						// 创建一个Request
						// 从clientPool.get 一个client 发送请求
						Request request = new Request();
						request.requestId = UUID.randomUUID().toString();
						request.setCommand(className+"."+method.getName());
						request.setContent(args);
						Response response = TcpClient.send(request);
						return response;
					}
				});
			}
		}
		
		return bean;
	}
 

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
