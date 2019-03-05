import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1863_종교_union {

	static int N;
	static int result;
	static ArrayList<Integer>[] list;
	static int[] parents;
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		// 1. make set
		Arrays.fill(parents, -1);
		
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		result = 0;
		for(int i=1;i<=N;++i) {
			if(parents[i]==-1)result++;
		}
		System.out.println(result);
	}

}
