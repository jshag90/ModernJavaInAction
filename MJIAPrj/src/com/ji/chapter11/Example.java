package com.ji.chapter11;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
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
	
	
	
	//11-8 프로퍼티에서 지속 시간을 읽는 명령형 코드
	public int readDuration(Properties props, String name) {
		String value = props.getProperty(name);
		if(value != null) {
			try {
				int i = Integer.parseInt(value);
				if(i > 0) {
					return i;
				}
			}catch(NumberFormatException nfe) {}
		}
		
		return 0;
	}
	
	//11-8 개선
	public int readDurationNew(Properties props, String name) {
		return Optional.ofNullable(props.getProperty(name))
				.flatMap(OptionalUtility::stringToInt)
				.filter(i -> i > 0 )
				.orElse(0);
	}
	
}
