package com.chun.java.current.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	static ExecutorService pool = Executors.newFixedThreadPool(1);
	public static void main(String[] args) {
		DefaultFuture defaultFuture = new DefaultFuture("d1");
		pool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DefaultFuture.setName("namemememme");
				
			}
		});
		String name = defaultFuture.getName();
		System.out.println("name======"+name);
		
		pool.shutdown();
	}
}
