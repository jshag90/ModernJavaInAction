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
		//��Ʈ�� �ڿ��� �ڵ��� ������ �� �ִ� AutoCloseable�̹Ƿ� try-finally�� �ʿ� ����.
		try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
			
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))) // ���� �ܾ� �� ���
										 .distinct() //�ߺ� ����
										 .count(); //�ܾ� ��Ʈ�� ����
			
		}catch(IOException e) {
			
		}
	}
}