import java.util.Scanner;

public class Solution1493_수의새로운연산 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] maxNum = new int[300];
		for(int i=0;i<maxNum.length;++i) {
			maxNum[i] = (i*i+i)/2;
		}
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int key = 0;
			for(int i=0;i<maxNum.length;++i) {
				if(maxNum[i]>=a) {
					key = i;
					break;
				}
			}
			int temp = maxNum[key]-a+1;
			int[] aPos = {key-temp+1,temp};
			for(int i=0;i<maxNum.length;++i) {
				if(maxNum[i]>=b) {
					key = i;
					break;
				}
			}
			temp = maxNum[key]-b+1;
			int[] bPos = {key-temp+1,temp};
			int[] cPos = {aPos[0]+bPos[0],aPos[1]+bPos[1]};
			int cc = cPos[0]+cPos[1];
			int tt = maxNum[cc-1];
			int c = tt-cPos[1]+1;
			System.out.println("#"+t+" "+c);
		}

	}

}
