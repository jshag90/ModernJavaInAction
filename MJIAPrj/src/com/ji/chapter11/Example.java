package com.ji.chapter11;

public class Example {

	
	//11-2 null 안전 시도 1: 깊은 의심
	public String getCarInsuranceName(Person person) {
		if(person != null) {
			Car car = person.getCar();
			if(car != null) {
				Insurance insurance = car.getInsurance();
				if(insurance != null) {
					return insurance.getName();
				}
			}
		}
		
		return "Unknown";
	}
	
}
