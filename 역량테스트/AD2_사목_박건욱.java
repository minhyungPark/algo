import java.util.*;
public class Solution {
	static int[][] map;
	static int height;
	static Queue<int[]> q;
	static int A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int Park=1;Park<=T;++Park) {
			
			map = new int[100][6];
			
			int N = sc.nextInt();
			int turn = 0;
			height = Integer.MAX_VALUE;
			q = new LinkedList<int[]>();
			A = 0;
			B = 0;
			for(int i=0;i<N;++i) {
				if(i%2==0) turn =1;
				else turn =2;
				
				int tmp = sc.nextInt();
				int row = 99;
				while(true) {
					if(map[row][tmp]==0)break;
					row--;
				}
				height = height<row?height:row;
				
				map[row][tmp] = turn;
				count(height,turn);
			}
			int GeonUk = Math.abs(A-B);
			System.out.println("#"+Park+" "+GeonUk);
		}
		
	}
	static void count(int r,int turn) {
		
		for(int i =r ;i<100;++i) {
			q.clear();
			OUTER: for(int c = 0;c<6;++c) {
				if(map[i][c] == 0) {
					q.clear();
					continue;
				}
				if(q.isEmpty()) {
					int[] tmp = {i,c};
					q.add(tmp);
					continue OUTER;
				}
				int[] t = q.peek();
				
				if(map[t[0]][t[1]] == map[i][c]) {
					int[] e = {i,c};
					q.add(e);
				}
				else q.clear();
			
				if (q.size()>=4) {
					int size = q.size();
					int[] m = q.peek();
					if(map[m[0]][m[1]] == turn ) {
						if(turn == 1) A+=size;
						else B+=size;
					}
					while(!q.isEmpty()){
						int[] p = q.poll();
						map[p[0]][p[1]] = 0;
					}
					down(r);
					count(height,turn);
					return;
				}
			}
		}
	}
	static void down(int r) {
		for(int i = 99;i>r;--i) {
			for(int c = 0; c<6;++c) {
				if(map[i][c] != 0) continue;
				map[i][c] = map[i-1][c];
				map[i-1][c] = 0;
			}
		}
	}

}
