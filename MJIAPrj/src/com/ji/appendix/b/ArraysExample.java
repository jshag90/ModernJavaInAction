package com.ji.appendix.b;

import java.util.Arrays;

public class ArraysExample {

	public static void main(String[] args) {
		setAllExample();
		parallelPrefixExample();
	}

	public static void setAllExample() {
		int[] evenNumbers = new int[10];
		Arrays.setAll(evenNumbers, i -> i * 2);
		for (int num : evenNumbers)
			System.out.println(num);
	}
	
	/**
	 * parallelPrefix() 배열의 각 요소를 병렬로 누적
	 */
	public static void parallelPrefixExample() {
		int[] ones = new int[10];
		Arrays.fill(ones, 1);
		Arrays.parallelPrefix(ones, (a, b) -> a+b);
		for (int num : ones)
			System.out.println(num);
	}

}
