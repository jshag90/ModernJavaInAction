package com.ji.appendix.b;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicExample {
	
	public void longAdderExample() {
		LongAdder adder = new LongAdder();
		adder.add(10);
		long sum = adder.sum();
	}
	
	public void longAccumulatorExample() {
		LongAccumulator acc = new LongAccumulator(Long::sum, 0);
		acc.accumulate(10);
		long result = acc.get();
	}

}
