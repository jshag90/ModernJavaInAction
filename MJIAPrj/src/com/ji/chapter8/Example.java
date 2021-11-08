package com.ji.chapter8;

import static java.util.Map.entry;

import java.util.Map;

public class Example {
	
	public static void main(String[] args) {
		
		//8.1.3 맵 팩토리
		Map<String, Integer> ageOfFriends = Map.ofEntries(entry("Raphael", 30), entry("Olivia", 25), entry("Thibaut", 26));
		System.out.println(ageOfFriends);
	}

}
