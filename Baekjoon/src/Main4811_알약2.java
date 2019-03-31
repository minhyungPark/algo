import java.util.HashSet;

public class Main4811_알약2 {
	
	static HashSet<String> set;
	public static void main(String[] args) {
		long[] arr = new long[31];
		for(int i=0;i<31;++i) {
			set = new HashSet<String>();
			dfs(i,i,0,new StringBuilder());
			arr[i] = set.size();
		}
		System.out.println();

	}

	private static void dfs(int depth,int w,int h,StringBuilder s) {
		
		if(w==0&&h==0) {
			set.add(s.toString());
			return;
		}
		
		if(w>0) {
			dfs(depth,w-1,h+1,s.append("w"));
		}
		if(h>0) {
			dfs(depth,w,h-1,s.append("h"));
		}
		
	}

}
