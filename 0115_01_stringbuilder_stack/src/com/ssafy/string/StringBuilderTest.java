package com.ssafy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringBuilderTest {

	// 입력스트림 : InputStream 	Reader
	// 출력스트림 : outputStream 	Writer
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		System.out.println(str);
		
		StringTokenizer st = new StringTokenizer(str);
//		String result ="";
		StringBuilder result = new StringBuilder("result:");
		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//			result.concat(st.nextToken());
			result.append(st.nextToken());
		}
		System.out.println(result.toString());
		
		result.append("!!").append("hello");
		System.out.println(result.toString());
		
		result.reverse();
		System.out.println(result.toString());
		
		st = new StringTokenizer(in.readLine()); // x y ==> 3 4
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		System.out.println(x+","+y);
		int z = Integer.parseInt(in.readLine());
		System.out.println(z);
	}

}
