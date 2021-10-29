package com.ji.chapter6;

import java.util.ArrayList;
import java.util.List;

public class example {

	public static void main(String[] args) {
		
		List<menu> menu = new ArrayList<menu>();
//		String shortMenu = tTYmenu.stream().map(Dish::getName).collect(joining(","));
		
		//6-3 각 서브그룹에서 가장 칼로리가 높은 요리 찾기
/**		
 		Map<Dish.Type, Dish> mostCaloricByType = 
				menu.stream()
						.collect(groupingBy(Dish::getType, // 분류함수 
									collectingAndThen(
										maxBy(comparingInt(Dish::getCalories)), //감싸인 컬렉터 
								Optional::get))); //변환 함수
**/			
				
	
	}
}

