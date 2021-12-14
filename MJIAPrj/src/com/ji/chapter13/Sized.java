package com.ji.chapter13;

import java.util.Iterator;
import java.util.function.Predicate;

public interface Sized {
	int size();
	default boolean isEmpty() {
		return size() == 0;
	}
	
	// Quiz 13-1 removeIf
//	default boolean removeIf(Predicate<? super E> filter) {
//		boolean removed = false;
//		Iterator<E> each = iterator();
//		while(each.hasNext()) {
//			if(filter.test(each.next())) {
//				each.remove();
//				removed = true;
//			}
//		}
//		return removed;
//	}
}
