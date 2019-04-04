import java.util.*;

public class Solution2383_점심식사시간v2 {

	static int N;
	static int[][] map;
	static int[][] dis;
	static int size;
	static ArrayList<int[]> person;
	static ArrayList<int[]> stair;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			map = new int[N][N];
			stair = new ArrayList<>();
			person = new ArrayList<>();
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
				map[i][j] = sc.nextInt();
					if(map[i][j]==1) {
						int[] temp = {i,j};
						person.add(temp);
					}else if(map[i][j]>1) {	
						int[] temp = {i,j};
						stair.add(temp);
					}
				}
			}// 입력 끝
			size = person.size();
			dis = new int[size][2];
			// dis 배열은 계단과 사람과의 거리가 저장되어있는 배열
			for(int i=0;i<size;++i) {
				for(int j=0;j<2;++j) {
					// distance라는 method를 만들어 주었다. 사람과 계단 사이의 거리를 구하는
					dis[i][j]=distance(person.get(i),stair.get(j));
				}
			}
			int[] num = new int[size];
			// 시작! dfs라는 함수는 어떤 계단을 선택할지 정해준다. 모든 경우에 대해 다 해본다.
			int res = dfs(0,num);
			System.out.println("#"+t+" "+res);
		}
		sc.close();
	}

	private static int distance(int[] person, int[] stair) {
		return Math.abs(person[0]-stair[0])+Math.abs(person[1]-stair[1]);
	}
	private static int dfs(int index, int[] num) {
		int res = Integer.MAX_VALUE;
		if(index==size) {
			// 모두 정해지면 계단을 내려가는 simul 실행
			return simul(num);
		}
		for(int i=0;i<2;++i) {
			num[index] = i;
			int temp = dfs(index+1,num);
			res = temp<res?temp:res;
		}
		return res;
	}

	private static int simul(int[] num) {
		int s1 =0;
		int s2 =0;
		for(int i=0;i<size;++i) {
			if(num[i]==0)s1++;
			else s2++;
		}
		// 계단 1로 가는 거리들만 모은 배열
		int[] temp1 = new int[s1];
		// 계단 2로 가는 거리들만 모은 배열
		int[] temp2 = new int[s2];
		int t1 = 0;
		int t2 = 0;
		for(int i=0;i<size;++i) {
			if(num[i]==0)temp1[t1++]=dis[i][0];
			else temp2[t2++]=dis[i][1];
		}
		Arrays.sort(temp1);
		Arrays.sort(temp2);
		// 계단 1로 가는 사람들과 계단 2로가는 사람들이 총 걸린 시간의 최대값이 결과
		int res1 = go(temp1,map[stair.get(0)[0]][stair.get(0)[1]]);
		int res2 = go(temp2,map[stair.get(1)[0]][stair.get(1)[1]]);
		
		return Math.max(res1, res2);
	}

	private static int go(int[] distance,int k) {
		if(distance.length==0)return 0;
		Queue<Integer> que= new LinkedList<>();
		int min = 0;
		boolean visited[] = new boolean[distance.length];
		// 1분씩 증가 시켜주면서 확인
		while(true) {
			// 계단을 다 내려갔는지 확인
			int qs = que.size();
			for(int i=0;i<qs;++i) {
				if(min-que.peek()==k)que.poll();
				else break;
			}
			// 계단에 내려 갈 수 있는지
			for(int i=0;i<distance.length;++i) {
				if(!visited[i]&&distance[i]<=min&&que.size()<3) {
					que.add(min);
					visited[i] = true;
				}
			}
			boolean flag = true;
			for(int i=0;i<visited.length;++i) {
				if(!visited[i]) {
					flag = false;
					break;
				}
			}
			min++;
			if(flag&&que.size()==0)break;
		}
		return min;
	}

}
