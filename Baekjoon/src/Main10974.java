import java.util.Scanner;

public class Main10974 {

	static int N;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		permutation(0,0);
	}
	private static void permutation(int index,int flag) {
		if(index==N) {
			for(int i=0;i<N;++i) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;++i) {
			if((flag&(1<<i))==0) {
				numbers[index] = i;
				permutation(index+1,flag|(1<<i));
			}
		}
	}
}
