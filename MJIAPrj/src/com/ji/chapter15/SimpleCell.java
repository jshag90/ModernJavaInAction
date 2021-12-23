package com.ji.chapter15;

import java.util.ArrayList;
import java.util.List;

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {
	private int value = 0;
	private String name;
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();

	public SimpleCell(String name) {
		this.name = name;
	}

	private void notifyAllSubscribers() {
		subscribers.forEach(subscriber -> subscriber.onNext(this.value));
	}
	
	@Override
	public void onNext(Integer newValue) {
		this.value = newValue;
		System.out.println(this.name + ":" +this.value);
		notifyAllSubscribers();

	}

	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		subscribers.add(subscriber);		
	}
}
