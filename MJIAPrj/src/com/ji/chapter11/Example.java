package com.ji.chapter11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	
	//11-6 사람 목록을 이용해 가입한 보험 회사 이름 찾기
	public Set<String> getCarInsuranceNames(List<Person> persons){
		return persons.stream().map(Person::getCar)
							  .map(optCar -> optCar.flatMap(Car::getInsurance))
							  .map(optIns -> optIns.map(Insurance::getName))
							  .flatMap(Optional::stream)
							  .collect(Collectors.toSet());
	}
	
}
