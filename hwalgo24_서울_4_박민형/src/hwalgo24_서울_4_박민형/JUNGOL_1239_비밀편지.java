package hwalgo24_서울_4_박민형;

import java.util.Scanner;

public class JUNGOL_1239_비밀편지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] abc = new int[8][7];
		abc[0][0] = 0;
		abc[1][0] = 15;
		abc[2][0] = 19;
		abc[3][0] = 28;
		abc[4][0] = 38;
		abc[5][0] = 41;
		abc[6][0] = 53;
		abc[7][0] = 58;
		for(int i=0;i<8;++i) {
			for(int j=1;j<=6;++j) {
				abc[i][j] = abc[i][0]^(1<<j-1);
			}
		}
		int N = sc.nextInt();
		String string = sc.next();
		int[] num = new int[N];
		for(int i=0;i<N;++i) {
			num[i] = Integer.parseInt(string.substring(i*6, (i+1)*6), 2);
		}
		StringBuilder sb = new StringBuilder();
		int result = -1;
		for(int i=0;i<N;++i) {
			boolean flag = false;
			for(int j=0;j<8;++j) {
				for(int k=0;k<7;++k) {
					if(flag)break;
					if(num[i]==abc[j][k]) {
						sb.append((char)(j+'A'));
						flag = true;
					}
				}
				if(flag)break;
			}
			if(!flag) {
				result=i+1;
				break;
			}
		}
		if(result!=-1)System.out.println(result);
		else System.out.println(sb.toString());
	}

}
