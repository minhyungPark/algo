import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10972_다음순열{

	static int N;
	static boolean[] checked;
	static int[] numbers;
	static int flag;
	static int[] results;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		checked = new boolean[N+1];
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		results = numbers.clone();
		flag=0;
		permutation(0);
		if(flag==1) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;++i) {
				sb.append(results[i]).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
		
	}
	private static void permutation(int index) {
		if(index==N) {
			if(flag==0) {
				flag = 1;
				return;
			}else if(flag==1) {
				flag = 2;
				return;
			}
		}		
		
		for(int i=1;i<=N;++i) {
			if(flag==1&&!checked[i]) {
				checked[i]=true;
				results[index] =i;
				permutation(index+1);
				checked[i]=false;
			}
			if(!checked[i]&&numbers[index]==i) {
				checked[i] = true;
				permutation(index+1);
				checked[i] = false;
			}
		}
		
	}

}
