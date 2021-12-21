package com.ji.chapter15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int x = 1337;
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> y =  executorService.submit(()->f(x));
		Future<Integer> z =  executorService.submit(() -> g(x));
		System.out.println(y.get() + z.get());
		
		executorService.shutdown();
	}

	private static Integer g(int x) {
		// TODO Auto-generated method stub
		return x;
	}

	private static Integer f(int x) {
		// TODO Auto-generated method stub
		return x;
	}

}
