import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2634_Jungol_사냥꾼 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] position = new int[M];
		int[][] animal = new int[N][2];
		st= new StringTokenizer(bf.readLine());
		for(int i=0;i<M;++i) {
			position[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(position);
		int result =0;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			animal[i][0] = Integer.parseInt(st.nextToken());
			animal[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] temp = new int[N];
		for(int i=0;i<N;++i) {
			temp[i] = animal[i][0];
		}
		for(int i=0;i<N;++i) {
			int key = Arrays.binarySearch(position, temp[i]);
			if(key>=0) {
				if(animal[i][1]<=L)result++;
			}else if(key<0){
				key = -1*key-1;
				if(key==0) {
					if(position[key]-animal[i][0]+animal[i][1]<=L)result++;
				}
				else if(position[key]-animal[i][0]+animal[i][1]<=L||
						(animal[i][0]-position[key-1])+animal[i][1]<=L) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
