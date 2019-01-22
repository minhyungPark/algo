import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2063_중간값찾기_박민형 {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<arr.length;++i) {
			arr[i] = sc.nextInt();
		}//입력끝
		
		for(int i=0;i<arr.length-1;++i) {
			for(int j=0;j<arr.length-i-1;++j) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(arr[N/2]);
	}
}
