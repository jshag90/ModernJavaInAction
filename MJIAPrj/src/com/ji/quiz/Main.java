package com.ji.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� 2-1 ������ prettyPrintApple �޼��� �����ϱ�
 * @author ji
 *
 */
public class Main {

	public static void main(String[] args) {
		
		List<Apple> inven = new ArrayList<>();
		Apple a1 = new Apple();
		a1.setColor("red");
		a1.setWeight(170);
		
		Apple a2 = new Apple();
		a2.setColor("blue");
		a2.setWeight(100);
		inven.add(a1);
		inven.add(a2);
		prettyPrintApple(inven, new AppleFancyFormatter());
		
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for(Apple apple: inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}


}
