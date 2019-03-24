import java.util.Scanner;

public class Test{

	static int N;
	static int[] numbers;
	static int[] op;
	static int size;
	static int max,min;
	static int[] opp; 
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for(int i=0;i<N;++i) {
			numbers[i]=sc.nextInt();
		}
		int[] operator=new int[4];
		size = 0;
		for(int i=0;i<4;++i) {
			operator[i]=sc.nextInt();
			size+=operator[i];
		}
		op = new int[size];
		opp = new int[size];
		visited= new boolean[size];
		int cnt=0;
		for(int i=0;i<4;++i) {
			int temp = operator[i];
			for(int j=0;j<temp;++j) {
				op[cnt++]=i;
			}
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0);
		
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	private static void dfs(int index) {

		if(index==size) {
			int sum = numbers[0];
			for(int i=0;i<size;++i) {
				if(opp[i]==0) {
					sum+=numbers[i+1];
				}else if(opp[i]==1) {
					sum-=numbers[i+1];
				}else if(opp[i]==2) {
					sum*=numbers[i+1];
				}else if(opp[i]==3) {
					sum=sum/numbers[i+1];
				}
			}
			if(max<sum)max=sum;
			if(min>sum)min=sum;
			return;
		}
		
		for(int i=0;i<size;++i) {
			if(visited[i])continue;
			visited[i]= true;
			opp[index] = op[i];
			dfs(index+1);
			visited[i]=false;
		}
	}

}
