import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3124_최소스패닝트리 {

	private static class Algo implements Comparable<Algo>{
		int from;
		int to;
		int weight;
		
		public Algo(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Algo o) {
			return this.weight - o.weight;
		}
		
	}
	static int N,E;
	static Algo[] list;
	static int[] parents;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=T;++t) {
			long result = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new Algo[E];
			parents = new int[N+1];
			Arrays.fill(parents, -1);
			
			for(int i=0;i<E;++i) {
				st = new StringTokenizer(bf.readLine());
				list[i] = new Algo(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(list);
			int cnt=0;
			int i=0;
			while(cnt<N && i<E) {
				if(union(list[i].from,list[i].to)) {
					result+=list[i].weight;
					cnt++;
				}
				++i;
			}
			
			System.out.println("#"+t+" "+result);
		}
		
	}
	static int find(int a) {
		if(parents[a]<0) return a;
		
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
}
