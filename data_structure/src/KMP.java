package com.ssafy.string.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm) 
// O(N+M)
public class KMP {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		// 실패함수 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		int[] fail = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터, j:접두사 포인터	
	        while(j > 0 && pattern[i] != pattern[j]) j = fail[j-1];
	        if(pattern[i] == pattern[j]) fail[i] = ++j;// j인덱스까지 일치하므로 길이는 j+1
	    }
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		// i : 텍스트 포인터 , j: 패턴 포인터 , i는 계속 증가하기만 하고 j만 바뀌며 그에 맞춰 패턴만 움직임.
		for(int i=0,j=0; i<tLength; ++i) { 
			
			// j위치에서 틀리면 j-1까지는 맞았다는 이야기, fail[j-1] : 이전글자까지의 	접미사의 길이로 이 값을 j로 취하면 일치하는 접두사  바로 다음 위치가 됨.
			while(j>0 && text[i] != pattern[j]) j = fail[j-1]; 
			
			if(text[i] == pattern[j]) { //두 글자 일치
				if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면
					cnt++;
					sb.append(i-pLength+1+1 + " ");
					j=fail[j];
				}else { // j가 패턴의 마지막 인덱스가 아니라면 j의 다음위치 비교하도록 값 증가
					j++;
				}
			}
		}
		
		if (cnt > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}