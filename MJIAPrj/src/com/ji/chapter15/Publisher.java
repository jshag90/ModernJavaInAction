package com.ji.chapter15;


public interface Publisher<T> {
	void subscribe(Subscriber<? super T> subscriber);
}
