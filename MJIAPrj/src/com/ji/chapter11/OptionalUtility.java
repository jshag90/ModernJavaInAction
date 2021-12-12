package com.ji.chapter11;

import java.util.Optional;

public class OptionalUtility {

	// 11-7 문자열을 정수 Optional로 변환
	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

}
