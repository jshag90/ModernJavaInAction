package com.ji.chapter16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Example {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Double> future = executor.submit(new Callable<Double>() {
			
			public Double call() {
				return doSomeLongComputation(); //시간이 오래 걸리는 작업은 다른 스레드에서 비동기적으로 실행
			}
			
		});
		
		doSomethingElse(); // 비동기 작업을 수행하는 동안 다른 작업을 한다.
		
		try {
			Double result = future.get(1, TimeUnit.SECONDS);
		}catch (ExecutionException ee) {
			// 계산 중 예외 발생
		}catch(InterruptedException ie) {
			// 현재 스레드에서 대기 중 인터럽트 발생
		}catch(TimeoutException te) {
			// Future가 완료되기 전에 타임 아웃 발생
		}
	}

	private static void doSomethingElse() {
		// TODO Auto-generated method stub
		
	}

	protected static Double doSomeLongComputation() {
		// TODO Auto-generated method stub
		return null;
	}

}
