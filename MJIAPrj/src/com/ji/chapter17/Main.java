package com.ji.chapter17;

import java.util.Arrays;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.reactivex.Observable;

public class Main {

	public static void main(String[] args) {
//		getTemperatures("New York").subscribe(new TempSubscriber());
//		getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
		Observable<TempInfo> observable = getCelsiusTemperate("New York", "Chicago", "San Francisco");
		observable.blockingSubscribe(new TempObserver());
	}

	private static Publisher<TempInfo> getTemperatures(String town) {
		return Subscriber -> Subscriber.onSubscribe(new TempSubscription(Subscriber, town));
	}
	
	public static Publisher<TempInfo> getCelsiusTemperatures(String town) {
		return Subscriber -> {
			TempProcessor processor = new TempProcessor();
			processor.subscribe(Subscriber);
			processor.onSubscribe(new TempSubscription(processor, town));
		};
	}

	public static Observable<TempInfo> getTemperature(String town) {
		return Observable.create(emitter ->
			Observable.interval(1, TimeUnit.SECONDS).subscribe(i -> {
				if (!emitter.isDisposed()) {
					if (i >= 5) {
						emitter.onComplete();
					} else {
						try {
							emitter.onNext(TempInfo.fetch(town));
						} catch (Exception e) {
							emitter.onError(e);
						}
					}
				}
			}));
		
	}
	
	public static Observable<TempInfo> getCelsiusTemperature(String town) {
		return getTemperature(town)
				.map(temp -> new TempInfo(temp.getTown(), 
						(temp.getTemp() - 32) * 5 / 9));
	}
	
	public static Observable<TempInfo> getNegativeTemperate(String town){
		return getCelsiusTemperature(town).filter(temp ->temp.getTemp() < 0);
	}
	
	public static Observable<TempInfo> getCelsiusTemperate(String... towns){
		return Observable.merge(Arrays.stream(towns)
				.map(Main::getCelsiusTemperate)
				.collect(Collectors.toList()));
	}
}
