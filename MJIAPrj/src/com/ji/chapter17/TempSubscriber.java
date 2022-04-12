package com.ji.chapter17;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempSubscriber implements Subscriber<TempInfo> {
	
	private Subscription subscription;

	/**
	 *  구독을 저장하고 첫 번째 요청을 전달
	 */
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	/**
	 * 수신한 온도를 출력하고 다음 정보를 요청
	 */
	@Override
	public void onNext(TempInfo tempInfo) {
		System.out.println(tempInfo);
		subscription.request(1);
	}

	/**
	 * 에러가 발생하면 에러 메시지 출력
	 */
	@Override
	public void onError(Throwable t) {
		System.err.println(t.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println("Done!");
	}

}
