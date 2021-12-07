package com.ji.chapter11;

import java.util.Optional;

public class Example {

	
	//11-2 null 안전 시도 1: 깊은 의심
//	public String getCarInsuranceName(Person person) {
//		if(person != null) {
//			Car car = person.getCar();
//			if(car != null) {
//				Insurance insurance = car.getInsurance();
//				if(insurance != null) {
//					return insurance.getName();
//				}
//			}
//		}
//		
//		return "Unknown";
//	}
	
	//11-5 Optional로 자동차의 보험회사 이름 찾기
	public String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
						 	 .flatMap(Car::getInsurance)
						 	 .map(Insurance::getName)
						 	 .orElse("Unknown"); // Optional이 비어있으면 기본값 사용
	}
	
}
