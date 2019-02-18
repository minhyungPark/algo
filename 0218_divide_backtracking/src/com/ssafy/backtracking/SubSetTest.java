package com.ssafy.backtracking;

import java.util.Scanner;

public class SubSetTest {

	static int[] inputs = new int[9];
	static boolean[] selected = new boolean[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;++i) {
			inputs[i] = sc.nextInt();
		}
		findSubSet(0,0,0);
		sc.close();
	}

	private static boolean findSubSet(int index,int count,int sum) {
		if(count==7 && sum==100) {
			for(int i=0;i<selected.length;++i) {
				if(selected[i]) {
					System.out.println(inputs[i]);
				}
			}
			return true;
		}else if(count==7||index==9) {
			return false;
		}
		
		boolean flag = false;
		if(sum+inputs[index]<=100) {
			//선택
			selected[index] = true;
			flag = findSubSet(index+1,count+1,sum+inputs[index]);
		}
		if(!flag) { // 위의 처리에서 해를 찾지 못했다면
			//비선택
			selected[index] = false;
			flag = findSubSet(index+1,count,sum);
		}
		
		return flag;
	}
}
