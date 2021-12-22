package com.ji.chapter15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFComplete02 {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		int x = 1337;
		CompletableFuture<Integer> a = new CompletableFuture<Integer>();
		executorService.submit(()->a.complete(g(x)));
//		int a = f(x);
//		System.out.println(a + b.get());
		
		executorService.shutdown();
	}

	private static Integer g(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int f(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
