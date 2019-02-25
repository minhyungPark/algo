import java.util.Scanner;

public class Main9633_nqueen {

	static int N;
	static int[] col;
	static int[] rightUp,rightDown;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		rightUp = new int[2*N];
		rightDown = new int[2*N];
		dfs(0);
		System.out.println(result);
		sc.close();
	}
	private static void dfs(int index) {
		if(index==N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(col[i]!=1 && rightUp[i+index]!=1 && rightDown[N+i-index]!=1) {
				col[i]=rightUp[i+index]= rightDown[N+i-index]=1;
				dfs(index+1);
				col[i]=rightUp[i+index]= rightDown[N+i-index]=0;
			}
			
		}
		
	}

}
