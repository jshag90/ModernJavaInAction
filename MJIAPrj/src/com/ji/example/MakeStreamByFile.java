package com.ji.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MakeStreamByFile {

	public static void main(String[] args) {
		long uniqueWords = 0; 
		//스트림은 자원을 자도응로 해제할 수 있는 AutoCloseable이므로 try-finally가 필요없다.
		try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
			
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))//고유 단어 수 계산
										 .distinct() //중복제거
										 .count(); //단어 스트림 생성
			
		}catch(IOException e) {
			
		}
	}
}
