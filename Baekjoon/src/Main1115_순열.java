import java.util.Scanner;

public class Main1115_순열 {

	static int N;
	static int[] numbersA;
	static int[] number;	
	static boolean[] checked;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbersA = new int[N];
		number = new int[N];
		checked = new boolean[N];
		for(int i=0;i<N;++i) {
			numbersA[i] = sc.nextInt();
		}
		
		permutation(0,0,0);
		
		System.out.println(min);
		sc.close();
	}

	private static void permutation(int depth,int index,int count) {
		if(depth == N-1) {
			number[index] = 0;
			if(number[index]!=numbersA[index]) {
				count++;
			}
			if(count<min)min = count;
			return;
		}
		if( count >= min ) {
			return;
		}
		
		for(int i=1;i<N;++i) {
			if(!checked[i]) {
				checked[i] = true;
				number[index] = i;
				int temp = count;
				if(number[index]!=numbersA[index]) {
					temp = count+1;
				}
				permutation(depth+1,i,temp);
				checked[i] = false;
			}
			
		}
		
	}

}
