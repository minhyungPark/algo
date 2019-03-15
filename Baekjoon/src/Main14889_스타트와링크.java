import java.util.Scanner;

public class Main14889_스타트와링크 {

	static int N;
	static int[][] map;
	static int result;
	static boolean[] visited;
	static int[] number;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		number = new int[N/2];
		result = Integer.MAX_VALUE;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0,0);
		System.out.println(result);
	}
	private static void dfs(int index,int jj) {
		
		if(index==N/2) {
			int a = 0;
			int b = 0;
			for(int i=0;i<N/2;++i) {
				for(int j=0;j<N/2;++j) {
					a=a+map[number[i]][number[j]];
				}
			}
			for (int is : number) {
				System.out.print(is+" ");
			}
			System.out.println();
			int[] temp= new int[N/2];
			int cnt = 0;
			for(int i=0;i<N;++i) {
				if(!visited[i])temp[cnt++] =i; 
			}
			for(int i=0;i<N/2;++i) {
				for(int j=0;j<N/2;++j) {
					b=b+map[temp[i]][temp[j]];
				}
			}
			if(result>Math.abs(a-b)) {
				result = Math.abs(a-b);
			}
			return;
		}
		
		for(int i=jj;i<N;++i) {
			if(!visited[i]) {
				visited[i] = true;
				number[index] = i;
				dfs(index+1,i);
				visited[i] = false;
			}
		}
		
	}

}
