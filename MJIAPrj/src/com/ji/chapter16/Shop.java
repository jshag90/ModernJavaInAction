package com.ji.chapter16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

//	public double getPrice(String product) {
//		return 0d;
//	}
	
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	public static void delay() {
		try {
			Thread.sleep(1000L);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	private double calculatePrice(String product) {
		delay();
		Random random = new Random();
		return random.nextDouble()*product.charAt(0) + product.charAt(1);
	}
	
	public Future<Double> getPriceAsync(String product){
		//계산 결과를 포함할 CompletableFuture를 생성
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		
		new Thread( () -> {
			double price = calculatePrice(product); // 다른 스레드에서 비동기적으로 계산을 수행
			futurePrice.complete(price);//오래 시간이 걸리면 계산이 완료되면 Future에 값을 설정
		}).start();
		
		return futurePrice; // 계산 결과가 완료되길 기다리지 않고 Future를 반환
	}

}
