import java.util.ArrayList;
import java.util.Scanner;

public class Main2589_보물섬_floyd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='L') {
					int[] node = {i,j};
					list.add(node);
				}
			}
		}
		int size = list.size();
		int[][] adjMatrix = new int[size][size];
		for(int i=0;i<size;++i) {
			int[] start = list.get(i);
			for(int j=0;j<4;++j) {
				int nx = start[0]+dx[j];
				int ny = start[1]+dy[j];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				for(int k=i+1;k<size;++k) {
					if(list.get(k)[0]==nx&&list.get(k)[1]==ny)adjMatrix[i][k]=1;
				}
			}
		}
		for(int i=0;i<size;++i) {
			for(int j=i+1;j<size;++j) {
				adjMatrix[j][i] = adjMatrix[i][j];
			}
		}
		for(int i=0;i<size;++i) {
			for(int j=0;j<size;++j) {
				if(i!=j&&adjMatrix[i][j]==0)adjMatrix[i][j] = 99999999;
			}
		}
		
		for(int k=0;k<size;++k) {
			for(int i=0;i<size;++i) {
				if(i==k)continue;
				for(int j=0;j<size;++j) {
					if(j==k||j==i)continue;
					if(adjMatrix[i][j]>adjMatrix[i][k]+adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<size;++i) {
			for(int j=0;j<size;++j) {
				if(adjMatrix[i][j]<size*size&&adjMatrix[i][j]>max) {
					max = adjMatrix[i][j];
				}
			}
		}
		
		System.out.println(max);
		
	}

}
