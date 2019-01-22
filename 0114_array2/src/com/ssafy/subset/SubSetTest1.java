package com.ssafy.subset;

public class SubSetTest1 {

	public static void main(String[] args) {
		
		boolean[] selected = new boolean[3]; //false로 자동 초기화
		
		for(int i=1;i>=0;--i) {	// 첫번째 원소 선택, 비선택 처리
			selected[0] = (i==1)?true:false;
			for(int j=1;j>=0;--j) {	// 첫번째 원소 선택, 비선택 처리
				selected[1] = (j==1)?true:false;
				for(int k=1;k>=0;--k) {	// 첫번째 원소 선택, 비선택 처리
					selected[2] = (k==1)?true:false;
					for(int s=0;s<3;++s) {
						System.out.print((selected[s]?(s+1):"X")+"\t");
					}
					System.out.println();
				}
			}			
		}
	}

}
