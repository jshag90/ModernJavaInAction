package com.ji.builder;

public class Main {

	public static void main(String[] args) {

		PersonInfoBuilder personInfoBuilder = new PersonInfoBuilder();

		PersonInfo result = personInfoBuilder.setName("seonhak").setFavoriteAnimal("cat").build();
		
		System.out.println(result.getPersonInfo());

	}

}
