package com.chun.netty.client.e1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultFuture {
	static ConcurrentHashMap< String, DefaultFuture> allDefaultFuture = new ConcurrentHashMap<>();
	public Response response;
	final Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public DefaultFuture(Request request) {
		allDefaultFuture.put(request.requestId, this);
	}

	// 这里进行 对对象进行加锁  ，在接收的时候，对对象进行枷锁
	public static  void receive(Response resp) {
	
		DefaultFuture df = allDefaultFuture.get(resp.responseId);
		if (df!=null) {
			Lock lock = df.lock;
			lock.lock();
			df.response = resp;
			df.condition.signal();
			allDefaultFuture.remove(resp.responseId);
			lock.unlock();
		}
	}

	public Response get() {
		lock.lock();
		try {
			while(response==null) {
					condition.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
		return response;
	 
	}
	
	

}
