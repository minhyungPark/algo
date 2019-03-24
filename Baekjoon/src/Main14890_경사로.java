import java.util.Scanner;

public class Main14890_경사로 {

	static int N,L;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		arr = new int[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				arr[i][j]=sc.nextInt();
			}
		}
		int result =0;
		for(int i=0;i<N;++i) {
			if(check(arr[i]))result++;
		}
		for(int i=0;i<N;++i) {
			int[] temp = new int[N];
			for(int j=0;j<N;++j) {
				temp[j]=arr[j][i];
			}
			if(check(temp))result++;
		}
		System.out.println(result);
		sc.close();
		
	}
	private static boolean check(int[] map) {
		
		int temp = map[0];
		boolean[] visited = new boolean[N];
		for(int i=0;i<N;) {
			if(temp!=map[i]) {
				if(Math.abs(temp-map[i])!=1)return false;
				if(temp>map[i]) {
					if(i+L>N)return false;
					int t = map[i];
					for(int j=i;j<i+L;++j) {
						if(map[j]!=t)return false;
						else visited[j]=true;
					}
					i=i+L-1;
					temp= t;
					continue;
				}else {
					if(i-L<0)return false;
					for(int j=i-1;j>=i-L;--j) {
						if(visited[j])return false;
						if(map[j]!=temp)return false;
						visited[j]=true;
					}
					i++;
					temp++;
					continue;
				}
			}else {
				i++;
			}
		}
		
		
		
		
		return true;
	}

}
