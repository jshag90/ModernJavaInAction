package com.ji.builder;

public class PersonInfoBuilder {
	private String name;
	private Integer age;
	private String favoriteColor;
	private String favoriteAnimal;
	private Integer favoriteNumber;

	public PersonInfoBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PersonInfoBuilder setAge(Integer age) {
		this.age = age;
		return this;
	}

	public PersonInfoBuilder setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
		return this;
	}

	public PersonInfoBuilder setFavoriteAnimal(String favoriteAnimal) {
		this.favoriteAnimal = favoriteAnimal;
		return this;
	}

	public PersonInfoBuilder setFavoriteNumber(Integer favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
		return this;
	}

	public PersonInfo build() {
		PersonInfo personInfo = new PersonInfo(name, age, favoriteColor, favoriteAnimal, favoriteNumber);
		return personInfo;
	}
}
