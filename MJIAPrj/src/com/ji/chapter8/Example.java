package com.ji.chapter8;

import static java.util.Map.entry;

import java.util.Map;
import java.util.Map.Entry;

public class Example {
	
	public static void main(String[] args) {
		
		//8.1.3 맵 팩토리
		Map<String, Integer> ageOfFriends = Map.ofEntries(entry("Raphael", 30), entry("Olivia", 25), entry("Thibaut", 26));
		System.out.println(ageOfFriends);
		
		//8.3.1 forEach메서드
		ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is "+ age + " years old"));
		
		//8.3.2 정렬 메서드
		Map<String, String> favouriteMovies = Map.ofEntries(
				entry("Raphael", "Star Wars"),
		//		entry("Cristina", "Matrix"), 
				entry("Olivia", "James Bond"));
		favouriteMovies.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
		
		//8.3.3 getOrDefault 메서드
		System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
		System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));
		
	}

}
