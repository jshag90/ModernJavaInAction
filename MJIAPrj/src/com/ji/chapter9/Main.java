package com.ji.chapter9;

public class Main {
	public static void main(String[] args) {
		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		f.notifyObservers("The queen said her Favourite book is Modern Java in Action!");
	}
	
}
