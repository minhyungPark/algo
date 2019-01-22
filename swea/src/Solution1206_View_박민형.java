import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1206_View_박민형 {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("input1206.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int[] height = new int[N];
			
			for(int i=0;i<N;++i) {
				height[i] = sc.nextInt();
			}
			int result = 0;
			
			for(int i=2;i<N-2;++i) {
				int ans = 0;
				if(height[i]>height[i-2]&&height[i]>height[i-1]&&height[i]>height[i+1]&&height[i]>height[i+2]) {
					ans = height[i]-height[i-2];
					for(int j=-2;j<=2;++j) {
						if(j==0)continue;
						if(ans>(height[i]-height[i+j]))ans = height[i]-height[i+j]; 
					}
				}
				result += ans;
			}
			System.out.println("# "+t+" "+result);
		}
	}
}
