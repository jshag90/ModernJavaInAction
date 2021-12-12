package com.ji.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Example {
	
	public static void main(String[] args) {
		// 12-8 미리 정의된 TemporalAdjusters 사용하기
		LocalDate date1 = LocalDate.of(2014, 3, 18);
		System.out.println(date1);
		LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		System.out.println(date2);
		LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date3);

	}
	
}
