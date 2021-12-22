package com.ji.chapter15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFComplete01 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		int x = 1337;

		CompletableFuture<Integer> a = new CompletableFuture<Integer>();
		executorService.submit(() -> a.complete(f(x)));
		int b = g(x);
		System.out.println(a.get() + b);

		executorService.shutdown();
	}

	private static int g(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static Integer f(int x) {
		// TODO Auto-generated method stub
		return null;
	}
}
