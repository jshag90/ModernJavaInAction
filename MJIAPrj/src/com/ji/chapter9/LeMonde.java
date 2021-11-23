package com.ji.chapter9;

public class LeMonde implements Observer{

	@Override
	public void notify(String tweet) {
		// TODO Auto-generated method stub
		if(tweet != null && tweet.contains("wine")) {
			System.out.println("Today cheese, wine and news! "+tweet);
		}
		
	}

}
