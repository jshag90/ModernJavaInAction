package com.ji.chapter5;

import java.util.stream.Stream;

/**
 * generate 메서드
 * @author ji
 *
 */
public class GenerateMethod {

	public static void main(String[] args) {
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}
}
