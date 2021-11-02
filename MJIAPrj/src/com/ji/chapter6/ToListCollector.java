package com.ji.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 6-5 ToListCollector
 * 
 * @author ji
 *
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	@Override
	public Supplier<List<T>> supplier() {
		return ArrayList::new;// 수집 연산의 시발점
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return List::add;// 탐색한 항목을 누적하고 바로 누적자를 고친다.
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity(); // 항등 함수
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> { // 두 번째 콘텐츠와 합쳐서 첫 번째 누적자를 고친다.
			list1.addAll(list2);// 변경된 첫 번째 누적자를 반환한다.
			return list1;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		//컬렉터의 플래그를 IDENTITY_FINISH, CONCURRENT로 설정한다.
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
	}

}
