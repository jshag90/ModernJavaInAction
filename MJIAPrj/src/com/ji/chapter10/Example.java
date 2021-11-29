package com.ji.chapter10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) throws IOException {
		//예제 10-1 반복 형식으로 예제 로그 파일에서 에러 행을 읽는 코드
		String fileName = "";
		List<String> errors = new ArrayList<>();
		int errorCount = 0;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		String line = bufferedReader.readLine();
		while (errorCount < 40 && line != null) {
			if (line.startsWith("ERROR")) {
				errors.add(line);
				errorCount++;
			}
		}
		line = bufferedReader.readLine();
		
		// 예제 10-2 함수형으로 로그 파일의 에러 행 읽음
		List<String> errors2 = Files.lines(Paths.get(fileName))
												.filter(li -> li.startsWith("ERROR"))
												.limit(40)
												.collect(Collectors.toList());
	}

}
