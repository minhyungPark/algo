import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2247_jungol_도서관 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[][] person = new int[N][2];
		for(int i=0;i<N;++i) {
			person[i][0] =sc.nextInt();
			person[i][1] =sc.nextInt();
		}
		Arrays.sort(person, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		int max1 = 0;
		int max2 = 0;
		int[] temp = person[0];
		for(int i=1;i<N;++i) {
			if(person[i][0]<=temp[1]) {
				int ans = person[i][1] - temp[0];
				if(max1<ans) max1 = ans;
			}else {
				temp = person[i];
			}
		}
		temp = person[0];
		for(int i=1;i<N;++i) {
			if(person[i][0]>temp[1]) {
				int ans = person[i][0]-temp[1];
				if(max2<ans)max2= ans;
				temp = person[i];
			}else {
				if(person[i][1]>temp[1])temp = person[i];
			}
		}
		System.out.println(max1+" "+max2);
	}

}
