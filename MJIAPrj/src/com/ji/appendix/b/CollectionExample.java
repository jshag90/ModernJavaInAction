package com.ji.appendix.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExample {
	
	public static void main(String[] args) {
		funtionalListExample();
	}
	
	public void legacyMapExample01() {
		Map<String, Integer> carInventory = new HashMap<>();
		Integer count = 0;
		if(carInventory.containsKey("Aston Martin")) {
			count = carInventory.get("Aston Martin");
		}
	}
	
	public void funtionalMapExample01() {
		Map<String, Integer> carInventory = new HashMap<>();
		Integer count  = carInventory.getOrDefault("Aston Martin ", 0);
	}
	
	public String legacyMapExample02(String url) {
		Map<String, String> cache = new HashMap<>();
		String data = cache.get(url);
		if(data == null) {
			data = legacyMapExample02(url);
			cache.put(url, data);
		}
		return data;
	}
	
	public String funtionalMapExample02(String url) {
		Map<String, String> cache = new HashMap<>();
		return cache.computeIfAbsent(url, this::funtionalMapExample02);
	}
	
	public static void funtionalListExample() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		numbers.replaceAll(x -> x * 2);
		System.out.println(numbers);
	}

}
