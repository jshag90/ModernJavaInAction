package com.ji.chapter9;

public class NYTimes implements Observer{

	@Override
	public void notify(String tweet) {
		// TODO Auto-generated method stub
		if(tweet != null && tweet.contains("money")) {
			System.out.println("Breaking news in NY! "+ tweet);
		}
		
	}

}
