import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2606_바이러스 {

	static boolean[] checked;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		checked = new boolean[N+1];
		ArrayList<Integer>[] link = new ArrayList[N+1];
		for(int i=0;i<N+1;++i) {
			link[i] = new ArrayList<Integer>();
		}
		
		int M = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a].add(b);
			link[b].add(a);
		}
		dfs(link,1);
		int count=0;
		for(int i=2;i<=N;++i) {
			if(checked[i])++count;
		}
		System.out.println(count);
	}
	private static void dfs(ArrayList<Integer>[] link,int a) {
		checked[a] = true;
		for(int i=0;i<link[a].size();++i) {
			if(!checked[link[a].get(i)]) {
				dfs(link,link[a].get(i));
			}
		}
	}

}
