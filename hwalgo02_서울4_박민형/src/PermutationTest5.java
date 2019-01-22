import java.util.Arrays;

public class PermutationTest5 {

	static int N ,R,numbers[];
	static int selected;
	
	
	public static void main(String[] args) {
		
		N = 3;
		R = 3;
		// 1,2,3
		selected = 0;
		numbers = new int[R];
		permutation(0);

	}
	
	private static void permutation(int index) {
		
		if(index == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//1부터 N까지 시도
		for(int i=1;i<=N;++i) {
			// 시도하는 수가 기존자리수까지 사용되지 않았다면
			if((selected&(1<<(i-1)))==0) {
				numbers[index] = i;
				selected = selected|(1<<(i-1));
				permutation(index+1);
				selected = selected^(1<<(i-1));
			}
		}
	}	
	
}
