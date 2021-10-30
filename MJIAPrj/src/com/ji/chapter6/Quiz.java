package com.ji.chapter6;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	
	public static void main(String[] args) {
		
		//6-2 partitioningBy 사용
		List<Menu> menu = new ArrayList<Menu>();
		// 다수준 분할 코드
		// menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.partitioningBy(d -> d.getCalories() > 500))) ;
		// { false={false=[chicken, prawns, salmon], true=[pork, beef]}, true={false=[rice, season fruit], true=[french fries, pizza]}}
		
		// menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.counting()));
		// {false=5, ture=4}
		
	}

}
