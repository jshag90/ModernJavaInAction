package com.ji.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Example {
	
	public static void main(String[] args) {
		// 12-8 미리 정의된 TemporalAdjusters 사용하기
		LocalDate date1 = LocalDate.of(2014, 3, 18);
		System.out.println(date1);
		LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		System.out.println(date2);
		LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date3);

		// 12-10 패턴으로 DateTimeFormatter 만들기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateFormatter1 = LocalDate.of(2014, 3, 18);
		String formattedDate = dateFormatter1.format(formatter);
		LocalDate dateFormatter2 = LocalDate.parse(formattedDate, formatter);
		System.out.println(dateFormatter2);
		
		// 12-11 지역화된 DateTimeFormatter 만들기
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
		LocalDate date1It = LocalDate.of(2014, 3, 18);
		String formattedDateIt = date1It.format(italianFormatter);
		LocalDate date2It = LocalDate.parse(formattedDateIt, italianFormatter);
		System.out.println(date2It);
		
		// 12-12 DateTimeFormatter 만들기
		DateTimeFormatter italianFormatterBuilder = new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_MONTH)
				.appendLiteral(". ")
				.appendText(ChronoField.MONTH_OF_YEAR)
				.appendLiteral(" ")
				.appendText(ChronoField.YEAR)
				.parseCaseInsensitive()
				.toFormatter(Locale.ITALIAN);
		
		LocalDate date2ItBuilder = LocalDate.parse(formattedDateIt, italianFormatterBuilder);
		System.out.println(date2ItBuilder);
	}
	
}
