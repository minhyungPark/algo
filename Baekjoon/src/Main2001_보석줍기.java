import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2001_보석줍기 {

	static private class Bosuk{
		int next;
		int amount;
		Bosuk(int next,int amount){
			this.next = next;
			this.amount = amount;
		}
		
	}
	
	static int N,M,K;
	static boolean[] isBosuk;
	static int result;
	static ArrayList<Bosuk>[] list;
	static boolean[][] visited;
	static int total;
	static int jae;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = 0;
		total = 0;
		isBosuk = new boolean[N+1];
		visited = new boolean[N+1][N+1];
		for(int i=0;i<K;++i) {
			isBosuk[Integer.parseInt(bf.readLine())] = true;
		}
		for(int i=0;i<=N;++i) {
			if(isBosuk[i])total++;
		}
		list = new ArrayList[N+1];
		for(int i=0;i<=N;++i) {
			list[i] = new ArrayList<Bosuk>();
		}
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			list[x].add(new Bosuk(y, a));
			list[y].add(new Bosuk(x, a));
		}
		max = 0;
		for(int i=0;i<list[1].size();++i) {
			if(list[1].get(i).amount>max)max=list[1].get(i).amount;
		}
		dfs(0,1,0);
		System.out.println(result);
		System.out.println(jae);
	}
	private static void dfs(int index,int ex,int cnt) {
		jae++;
		if(index!=0&&ex==1) {
			int ans = cnt;
			if(isBosuk[1])ans++;
			if(result<ans)result = ans;
			return;
		}
		
		if(cnt>max)return;
		if(index>M)return;
		if(!isBosuk[1]&&result==max)return;
		if(isBosuk[1]&&result==max+1)return;
		 
		for(int i=0;i<list[ex].size();++i) {
			Bosuk temp = list[ex].get(i);
			int next = temp.next;
			int amount = temp.amount;
			if(cnt<=amount&&!visited[cnt][next]) {
				visited[cnt][next] = true;
				dfs(index+1,next,cnt);
				visited[cnt][next] = false;
			}
			if(isBosuk[ex]&&cnt+1<=amount&&!visited[cnt+1][next]) {
				visited[cnt+1][next] = true;
				isBosuk[ex]=false;
				dfs(index+1,next,cnt+1);
				isBosuk[ex]=true;
				visited[cnt+1][next] = false;
			}
		}
		
		
	}

}
