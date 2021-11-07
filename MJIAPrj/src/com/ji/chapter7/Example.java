package com.ji.chapter7;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Example {
	
	final static String SENTENCE = 
			"Nel      mezzo del cammin di nostra vita "+
			"mi ritrovai in una    selva oscura"+
			"ch la dritta via era    smarrita ";

	public static void main(String[] args) {
		System.out.println(sequentialSum(100));
		System.out.println("Found "+countWordsInteratively(SENTENCE)+ " words");
		Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
//		System.out.println("Found "+countWords(stream)+ " words");
		System.out.println("Found "+countWords(stream.parallel())+ " words"); //병렬 처리 문제로 이상한 결과 
		
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> streamPa = StreamSupport.stream(spliterator, true);
		
		System.out.println("Found "+countWords(streamPa)+" words");
		
	}

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	public long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	
	/**
	 * 예제 7-4 반복형으로 단어 수를 세는 메서드
	 * @param s
	 * @return
	 */
	public static int countWordsInteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) counter++; 
				lastSpace = false;
			}
		}
		return counter;
	}
	
	private static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCounter();
	}

}
