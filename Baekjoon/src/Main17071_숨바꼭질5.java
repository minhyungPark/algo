import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17071_숨바꼭질5 {

	static int N, K;
	static int result;
	static final int max = 500000;
	static final int maxS = 1002;
	static int[] kk;
	static boolean[] checked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		kk = new int[1002];
		checked = new boolean[500001];
		kk[0] = K;
		for (int i = 1; i <= 1000; ++i) {
			kk[i] = K + i * (i + 1) / 2;
			if (kk[i] > max) {
				kk[i] = 0;
				break;
			}
		}
		result = maxS;
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t = {N,0};
		que.add(t);
		int sec = 0;
		while(!que.isEmpty()) {
			int[] c= que.poll();
			int n = c[0];
			int s = c[1];
			if(sec!=s) {
				sec=s;
				checked = new boolean[500001];
			}
			if(s!=0&&kk[s]==0) {
				break;
			}
			if(kk[s]==n) {
				result = s;
				break;
			}
			if(2*n<=max&&!checked[2*n]) {
				checked[2*n] = true;
				int[] temp = {2*n,s+1};
				que.add(temp);
			}
			if (n < max&&!checked[n+1]) {
				checked[n+1] = true;
				int[] temp = {n+1,s+1};
				que.add(temp);
			}
			if (n - 1 >= 0&&!checked[n-1]) {
				checked[n-1] = true;
				int[] temp = {n-1,s+1};
				que.add(temp);
			}
			
		}
		
		if (result == maxS)
			result = -1;
		System.out.println(result);
	}

}
