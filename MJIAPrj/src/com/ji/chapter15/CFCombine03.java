package com.ji.chapter15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFCombine03 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		int x = 1337;
		
		CompletableFuture<Integer> a = new CompletableFuture<Integer>();
		CompletableFuture<Integer> b = new CompletableFuture<Integer>();
		CompletableFuture<Integer> c = a.thenCombine(b, (y, z) -> y+z);
		executorService.submit(() -> a.complete(f(x)));
		executorService.submit(() -> b.complete(g(x)));
		
		System.out.println(c.get());
		executorService.shutdown();
		
		
	}

	private static Integer g(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Integer f(int x) {
		// TODO Auto-generated method stub
		return null;
	}
}
