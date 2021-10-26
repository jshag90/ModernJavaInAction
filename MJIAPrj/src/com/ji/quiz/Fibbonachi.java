package com.ji.quiz;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibbonachi {

	public static void main(String[] args) {
		
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0]+t[1]})
		.limit(20)
		.forEach(t -> System.out.println("("+t[0]+","+t[1]+")"));
		
		IntStream.iterate(0, n -> n+4)
		.takeWhile(n -> n < 100)
		.forEach(System.out::println);

	}

}
