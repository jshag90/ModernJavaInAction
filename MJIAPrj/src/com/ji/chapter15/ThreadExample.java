package com.ji.chapter15;

public class ThreadExample {

	static int f(int x) {
		return x;
	}

	static int g(int x) {
		return x;
	}

	public static void main(String[] args) throws InterruptedException {
		int x = 1337;
		Result result = new Result();
//		
		Thread t1 = new Thread(() -> {
			result.left = f(x);
		});
		
		Thread t2 = new Thread(() -> {
			result.right = g(x);
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(result.left + result.right);

	}

}
