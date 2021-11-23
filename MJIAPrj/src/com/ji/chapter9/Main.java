package com.ji.chapter9;

public class Main {
	public static void main(String[] args) {
		
		//옵저버 패턴
		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		f.notifyObservers("The queen said her Favourite book is Modern Java in Action!");
		
		//의무 체인
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		p1.setSuccessor(p2);//두 작업 처리 객체를 연결한다.
		String result = p1.handle("Arent't labdas really sexy?!!");
		System.out.println(result);
	}
	
}
