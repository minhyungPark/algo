import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2001_보석줍기2 {

	static int N,M,K;
	static boolean[] isBosuk;
	static int[] bosuk;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 그 섬에 보석이 있는지.. 있으면 TRUE;
		isBosuk = new boolean[N+1];
		for(int i=0;i<K;++i) {
			isBosuk[Integer.parseInt(bf.readLine())]=true;
		}
		
		// 보석마다 번호를 붙여준다. ( 비트 마스킹을 사용하기 위해 )
		int cnt =0;
		bosuk = new int[N+1];
		for(int i=1;i<=N;++i) {
			if(isBosuk[i]) {
				bosuk[i]=cnt++;
			}
		}
		// 다리의 정보를 저장해준다.
		arr = new int[N+1][N+1];
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int k =Integer.parseInt(st.nextToken());
			arr[a][b] = k;
			arr[b][a] = k;
		}
		// BFS 시작
		int result = bfs();
		System.out.println(result);
		
	}
	private static int bfs() {
		boolean[][] visited = new boolean[(int) Math.pow(2,K)][N+1];
		Queue<int[]> que = new LinkedList<>();
		// 시작점, 보석을 가지고 있는 상태, 보석 개수
		int[] t = {1,0,0};
		que.offer(t);
		visited[0][1]=true;
		int ans = 0;
		while(!que.isEmpty()) {
			int[] c= que.poll();
			int w = c[0];
			int f = c[1];
			int k = c[2];
			// 다시 1번 섬으로 돌아왔을 때
			if(k!=0&&w==1) {
				if(ans<k)ans=k;
				if(isBosuk[w]&&(f&1)==0) {
					ans=ans<k+1?k+1:ans;
				}
			}
			
			for(int i=1;i<=N;++i) {
				if(arr[w][i]==0)continue;	// 연결되어 있지 않는 다리이므로...
				// 보석이 있을때 보석을 가져가보는 시도
				if(isBosuk[i]&&arr[w][i]>=k+1) {
					int flag = 1;
					flag = flag<<bosuk[i];
					if((flag&f)==0&&!visited[f|flag][i]) {
						visited[f|flag][i] = true;
						int[] temp = {i,f|flag,k+1};
						que.offer(temp);
					}
				}
				// 그냥 지나가는 시도
				if(arr[w][i]>=k&&!visited[f][i]) {
					visited[f][i] = true;
					int[] temp = {i,f,k};
					que.offer(temp);
				}
			}
		}
		
		
		return ans;
	}

}
