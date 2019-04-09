import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	
	static int N,M,D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i =0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		int[] num = new int[3];
		int res = comb(0,0,0,map,num);
		System.out.println(res);
		sc.close();
	}
	private static int comb(int index, int start, int flag,int[][] map,int[] num) {
		int res = Integer.MIN_VALUE;
		if(index==3) {
			//새로운 맵에 복사
			int[][] tMap = new int[N][M];
			clone(tMap,map);
			// 시뮬레이션 시작
			int ss = simul(tMap,num);
			return ss;
		}
		
		for(int i=start;i<M;++i) {
			if((flag&(1<<i))!=0)continue;
			num[index] = i;
			int temp = comb(index+1, i, flag|1<<i, map, num);
			res = res<temp?temp:res;
		}
		return res;
	}
	private static int simul(int[][] map, int[] num) {
		int cnt = 0;
		while(true) {
			// 맵에 적이 있는지 확인
			boolean flag = check(map);
			if(!flag) break;
			
			// 쏠수 있는 적 리스트
			ArrayList<int[]> list = shoot(map,num);
			
			for(int i=0;i<list.size();++i) {
				int[] c = list.get(i);
				// 한명의 적을 동시 저격 할수 있으므로..
				if(map[c[0]][c[1]]!=0) {
					cnt++;
					map[c[0]][c[1]]=0;
				}
			}
			// 앞으로 전진
			foward(map);
		}
		return cnt;
	}
	private static void foward(int[][] map) {
		
		for(int j=0;j<M;++j) {
			for(int i=N-1;i>0;--i) {
				map[i][j]=map[i-1][j];
			}
			map[0][j]=0;
		}
		
	}
	private static ArrayList<int[]> shoot(int[][] map, int[] num) {
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int i=0;i<3;++i) {
			int[] temp = who(map,num[i]);
			if(temp!=null)list.add(temp);
		}
		
		return list;
	}
	private static int[] who(int[][] map, int where) {
		for(int d=1;d<=D;++d) {
			for(int j=0;j<M;++j) {
				for(int i=N-1;i>=0;--i) {
					if(map[i][j]==1) {
						int dis = Math.abs(where-j)+Math.abs(N-i);
						if(dis==d) {
							int[] temp = {i,j};
							return temp;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	private static boolean check(int[][] map) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==1)return true;
			}
		}
		return false;
	}
	private static void clone(int[][] tMap, int[][] map) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				tMap[i][j]=map[i][j];
			}
		}
	}

}
