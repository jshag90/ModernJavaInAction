package com.ji.chapter15;

public interface Subscriber<T> {
	void onNext(T t);
}
