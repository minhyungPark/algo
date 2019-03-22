import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1938_통나무옮기기 {

	static int N;
	static int[][] map;
	static boolean[][][] checked;
	static int[][] end;
	static int[] dx= {0,0,-1,1,1,1,-1,-1};
	static int[] dy= {1,-1,0,0,-1,1,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		checked = new boolean[2][N][N];
		int[][] start = new int[3][3];
		end = new int[2][3];
		int c=0;
		int cc=0;
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<N;++j) {
				if(temp[j]=='B') {
					start[0][c]=i;
					start[1][c++]=j;
				}else if(temp[j]=='1') {
					checked[0][i][j] = true;
					checked[1][i][j] = true;
					map[i][j]=1;
				}
				else if(temp[j]=='E') {
					end[0][cc]=i;
					end[1][cc++]=j;
				}
			}
		}
		int ans = 0;
		int d = 0;
		if(start[0][0]!=start[0][1])d=1;
		int[] a = {d,0};
		start[2] = a;
		Queue<int[][]> que = new LinkedList<>();
		for(int i=0;i<3;++i) {
			checked[d][start[0][i]][start[1][0]]=true;
		}
		que.add(start);
		while(!que.isEmpty()) {
			int[][] cu = que.poll();
			int[][] pr = new int[N][N];
			int dir = cu[2][0];
			int cnt = cu[2][1];
			for(int i=0;i<3;++i) {
				pr[cu[0][i]][cu[1][i]]=1;
			}
			System.out.println(cnt);
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					System.out.print(pr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			boolean flag = true;
			for(int i=0;i<3;++i) {
				if(cu[0][i]!=end[0][i]||cu[1][i]!=end[1][i]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				ans = cnt;
				break;
			}
			//상,하,좌,우
			for(int dd=0;dd<4;++dd) {
				boolean ff = true;
				int[] nx = new int[3];
				int[] ny = new int[3];
				for(int i=0;i<3;++i) {
					nx[i] = cu[0][i]+dx[dd];
					ny[i] = cu[1][i]+dy[dd];
				}
				for(int i=0;i<3;++i) {
					if(nx[i]<0||ny[i]<0||nx[i]>=N||ny[i]>=N) {
						ff = false;
						break;
					}
				}
				if(!ff)continue;
				ff = false;
				for(int i=0;i<3;++i) {
					if(!checked[dir][nx[i]][ny[i]]) {
						ff = true;
						break;
					}
				}
				if(!ff) continue;
				for(int i=0;i<3;++i) {
					if(map[nx[i]][ny[i]]==1) {
						ff = false;
						break;
					}
				}
				if(!ff) continue;
				for(int i=0;i<3;++i) {
					checked[dir][nx[i]][ny[i]] = true;
				}
				int[][] temp = {nx,ny,{dir,cnt+1}};
				que.add(temp);
			}
			//회전
			int x = cu[0][1];
			int y = cu[1][1];
			boolean f = true;
			for(int i=0;i<8;++i) {
				int nnx = x+dx[i];
				int nny = y+dy[i];
				if(nnx<0||nny<0||nnx>=N||nny>=N) {
					f=false;
					break;
				}
				if(map[nnx][nny]==1) {
					f=false;
					break;
				}
			}
			if(!f)continue;
			int nd = (dir+1)%2;
			int[] nx = new int[3];
			int[] ny = new int[3];
			if(nd==0) {
				nx[0]=x;
				nx[1]=x;
				nx[2]=x;
				ny[0]=y-1;
				ny[1]=y;
				ny[2]=y+1;
			}
			else if(nd==1) {
				nx[0]=x-1;
				nx[1]=x;
				nx[2]=x+1;
				ny[0]=y;
				ny[1]=y;
				ny[2]=y;
			}
			f=false;
			for(int i=0;i<3;++i) {
				if(!checked[nd][nx[i]][ny[i]]) {
					f = true;
					break;
				}
			}
			if(!f)continue;
			for(int i=0;i<3;++i) {
				checked[nd][nx[i]][ny[i]]= true;
			}
			int[][] temp= {nx,ny,{nd,cnt+1}};
			que.add(temp);
		}
		System.out.println(ans);
		
		
		
	}

}
