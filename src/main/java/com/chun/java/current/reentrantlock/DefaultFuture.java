package com.chun.java.current.reentrantlock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultFuture {
	private static ConcurrentHashMap<String, DefaultFuture> allDF= new ConcurrentHashMap<>();
	public DefaultFuture(String key) {
		allDF.put(key, this);
	}
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public String name;
	
	public static void setName(String name) {
		DefaultFuture df = allDF.get("d1");
		System.out.println("before set name ");
		df.lock.lock();
		
		df.condition.signal();
		System.out.println("set name ing");
		df.name = name;
		df.lock.unlock();
	}
	
	public String getName(){
		lock.lock();
		 
		try {
			while(name==null) {
					condition.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		lock.unlock();
		return name;
	}
	

}
