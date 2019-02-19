import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution1251_하나로 {

	private static class Node implements Comparable<Node>{
		
		int from;
		int to;
		double weight;
		public Node(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight>=o.weight?1:-1;
		}
		
	}
	
	
	static int N;
	static Node[] list;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1251.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			double result = 0;
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer stX = new StringTokenizer(bf.readLine());
			StringTokenizer stY = new StringTokenizer(bf.readLine());
			int[][] arr = new int[N][2];
			parents = new int[N];
			Arrays.fill(parents, -1);
			list = new Node[N*(N-1)/2];
			for(int i=0;i<N;++i) {
				arr[i][0] = Integer.parseInt(stX.nextToken());
				arr[i][1] = Integer.parseInt(stY.nextToken());
			}
			double tax = Double.parseDouble(bf.readLine());
			int index=0;
			for(int i=0;i<N-1;++i) {
				for(int j=i+1;j<N;++j) {
					long x = arr[i][0] - arr[j][0];
					long y = arr[i][1] - arr[j][1];
					double temp = ((x*x*tax)+(y*y*tax));
//					long temp = ((x*x)+(y*y));
//					long temp = (Math.pow(x, 2)+Math.pow(y, 2));
//					System.out.println(temp);
					list[index++] = new Node(i, j, temp);
				}
			}
			Arrays.sort(list);
			int cnt=0;
			int i=0;
			while(cnt<N && i<list.length) {
				if(union(list[i].from,list[i].to)) {
					result+=list[i].weight;
					cnt++;
				}
				++i;
			}
			
			
			System.out.printf("#%d %.0f\n",t,result);
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
