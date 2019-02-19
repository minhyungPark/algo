import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1767_프로세서연결하기 {

	private static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "Pair [i=" + i + ", j=" + j + "]";
		}
		
	}
	private static class List{
		Pair current;
		List next;
		public List(Pair current, List next) {
			this.current = current;
			this.next = next;
		}
		public List(Pair current) {
			this.current = current;
		}
		@Override
		public String toString() {
			return "List [current=" + current + ", next=" + next + "]";
		}
		
	}
	
	static int N;
	static boolean[][] map;
	static List head;
	static int result;
	static int coreMax;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input1767.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			result=Integer.MAX_VALUE;
			coreMax = Integer.MIN_VALUE;
			N = Integer.parseInt(bf.readLine());
			map = new boolean[N][N];
			head = null;
			for(int i=0;i<N;++i) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0;j<N;++j) {
					if(Integer.parseInt(st.nextToken())==1) {
						map[i][j] = true;
						List temp = new List(new Pair(i, j));
						temp.next=head;
						head = temp;
					}
				}
			}
			dfs(head,0,0);
			System.out.println("#"+t+" "+result);
		}
		
	}
	private static void dfs(List list,int sum,int core) {
		if(list==null) {
			if(core>coreMax) {
				coreMax =core;
				result = sum;
			}else if(core==coreMax) {
				if(sum<result) {
					result = sum;
				}
			}
			return;
		}
		
		Pair p = list.current;
		if(p.i==0||p.i==N-1||p.j==0||p.j==N-1) {
			dfs(list.next,sum,core+1);
		}else {
			int x=p.i;
			int y=p.j;
			boolean[] flag = new boolean[4];
			//상
			for(int i=0;i<x;++i) {
				if(map[i][y]) {
					flag[0] = true;
					break;
				}
			}
			if(!flag[0]) {
				for(int i=0;i<x;++i) {
					map[i][y] = true;
				}
				dfs(list.next,sum+x,core+1);
				for(int i=0;i<x;++i) {
					map[i][y] = false;
				}
			}
			//하
			for(int i=x+1;i<N;++i) {
				if(map[i][y]) {
					flag[1] = true;
					break;
				}
			}
			if(!flag[1]) {
				for(int i=x+1;i<N;++i) {
					map[i][y] = true;
				}
				dfs(list.next,sum+(N-1-x),core+1);
				for(int i=x+1;i<N;++i) {
					map[i][y] = false;
				}
			}
			
			//좌
			for(int i=0;i<y;++i) {
				if(map[x][i]) {
					flag[2] = true;
					break;
				}
			}
			if(!flag[2]) {
				for(int i=0;i<y;++i) {
					map[x][i] = true;
				}
				dfs(list.next,sum+y,core+1);
				for(int i=0;i<y;++i) {
					map[x][i] = false;
				}
			}
			//우
			for(int i=y+1;i<N;++i) {
				if(map[x][i]) {
					flag[3] = true;
					break;
				}
			}
			if(!flag[3]) {
				for(int i=y+1;i<N;++i) {
					map[x][i] = true;
				}
				dfs(list.next,sum+(N-1-y),core+1);
				for(int i=y+1;i<N;++i) {
					map[x][i] = false;
				}
			}
			int cnt=0;
			for(int i=0;i<4;++i) {
				if(flag[i])cnt++;
			}
			if(cnt==4) {
				dfs(list.next,sum,core);
			}
			
		}
	}

}
