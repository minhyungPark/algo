import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1208_Flatten_박민형 {

	public static void main(String[] args) throws FileNotFoundException{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
				
		int T = 10;
		for(int t=1;t<=T;++t) {
			int dumpNum = sc.nextInt();
			int[] arr = new int[101];
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i=0;i<100;++i) {
				int height=sc.nextInt();
				arr[height]++;
				if(min>height)min=height;
				if(max<height)max=height;
			}
			int result = max-min;
			for(int i=0;i<dumpNum;++i) {
				if(max-min==1||max-min==0) {
					break;
				}else {
					--arr[max];
					--arr[min];
					++arr[min+1];
					++arr[max-1];
					while(arr[max]==0)--max;
					while(arr[min]==0)++min;
					result = max-min;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
