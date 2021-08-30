package com.ji.quiz.pretty_print_apple;

public class AppleSimpleFormatter implements AppleFormatter {
	@Override
	public String accept(Apple apple) {
		return "An apple of " + apple.getWeight() + "g";
	}

}
