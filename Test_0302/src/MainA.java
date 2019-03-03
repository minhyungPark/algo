import java.util.Scanner;

public class MainA {
	
	static int N;
	static boolean[] broken;
	static int[][] eggList;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		eggList = new int[N][3];
		broken = new boolean[N];
		for(int i=0;i<N;++i) {
			eggList[i][0] = sc.nextInt();
			eggList[i][1] = sc.nextInt();
			eggList[i][2] = i;
		}
		result = 0;
		
		dfs(0,0);
		System.out.println(result);
		

	}
	private static void dfs(int index,int cnt) {
		
		if(index==N) {
			if(cnt>result)result=cnt;
			return;
			
		}
		if(broken[index]) {
			dfs(index+1,cnt);
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(!broken[i]&&i!=index) {
				int temp = cnt;
				eggList[index][0]-= eggList[i][1];
				if(eggList[index][0]<=0) {
					broken[index] = true;
					temp++;
				}
				eggList[i][0]-= eggList[index][1];
				if(eggList[i][0]<=0) {
					broken[i] = true;
					temp++;
				}
				dfs(index+1,temp);
				eggList[index][0]+= eggList[i][1];
				eggList[i][0]+= eggList[index][1];
				broken[index] = false;
				broken[i] = false;
			}
			
		}
		if(index==N-1) {
			int flag = 0;
			for(int i=0;i<N-1;++i) {
				if(broken[i])flag++;
			}
			if(flag==N-1)dfs(index+1,cnt);
			
		}
	}

}
