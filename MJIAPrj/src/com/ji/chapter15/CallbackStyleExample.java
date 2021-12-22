package com.ji.chapter15;

import java.util.function.IntConsumer;

public class CallbackStyleExample {

	static void f(int x, IntConsumer dealWithResult) {
	}
	
	static void g(int x, IntConsumer dealWithResult) {
	}

	public static void main(String[] args) {
		int x = 1337;
		Result result = new Result();
		
		f(x, (int y) -> {
			result.left = y;
			System.out.println((result.left + result.right));
		});
		
		g(x, (int z) -> {
			result.right = z;
			System.out.println((result.left + result.right));
		});
		
	}


}
