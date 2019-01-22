import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1204_최빈수구하기_박민형 {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("input1204.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int a = sc.nextInt();
			int[] arr = new int[1000];
			for(int i=0;i<arr.length;++i) {
				arr[i] = sc.nextInt();
			}
			bubbleSort2(arr);
			int result=0;
			int resultNum=0;
			int i=0;
			while(i<arr.length) {
				int cnt=0;
				for(int j=i;j<arr.length;++j) {
					if(arr[i]==arr[j]) {
						++cnt;
					}else {
						i=j;
						System.out.println(i);
						break;
					}
				}
				if(result<=cnt) {
					result = cnt;
					resultNum = arr[i-1];
				}
			}
			System.out.println("#"+a+" "+resultNum);
		}
		
		
	}
	private static void bubbleSort2(int[] arr) {
		int size = arr.length;
		boolean isSwap = false;
		int temp=0;
		for(int i=size-1;i>0;--i) {
			isSwap = false;
			for(int j=0;j<i;++j) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSwap = true;
				}
			}
			if(!isSwap)break;
		}
	}


}
