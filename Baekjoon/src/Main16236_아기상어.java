import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16236_아기상어 {

	static int N;
	static int[][] map;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int[] baby = new int[4];
		baby[2] = 2;
		baby[3] = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==9) {
					map[i][j]=0;
					baby[0]=i;
					baby[1]=j;
				}
			}
		}
		result = 0;
		while(true) {
			int[] c = bfs(baby);
			if(c[2]==Integer.MAX_VALUE)break;
			baby[0] = c[0];
			baby[1] = c[1];
			baby[3]++;
//			System.out.println(baby[2]);
			if(baby[2]==baby[3]) {
				baby[2]++;
				baby[3]=0;
			}
			map[c[0]][c[1]]=0;
			result+=c[2];
			
			System.out.println(c[2]);
			System.out.println(c[0]+" "+c[1]);
			for (int[] m : map) {
				for (int i : m) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(result);
		
	}
	private static int[] bfs(int[] baby) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> que = new LinkedList<>();
		int[] t= {baby[0],baby[1],baby[2],0};
		visited[baby[0]][baby[1]] = true;
		que.offer(t);
		int[] res = new int[3];
		Arrays.fill(res, Integer.MAX_VALUE);
		
		while(!que.isEmpty()) {
			int[] c = que.poll();
			
			if(map[c[0]][c[1]]!=0&&map[c[0]][c[1]]<c[2]) {
				if(c[3]<=res[2]) {
					if(res[0]>c[0]) {
						res[0] = c[0];
						res[1] = c[1];
						res[2] = c[3];
					}else if(res[0]==c[0]&&res[1]>c[1]) {
						res[0] = c[0];
						res[1] = c[1];
						res[2] = c[3];
					}
					continue;
				}
			}
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(visited[nx][ny])continue;
				if(map[nx][ny]>c[2])continue;
				visited[nx][ny] = true;
				int[] temp = {nx,ny,c[2],c[3]+1};
				que.offer(temp);
			}
		}
		return res;
	}

}
