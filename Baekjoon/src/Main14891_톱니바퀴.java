import java.util.Scanner;

public class Main14891_톱니바퀴 {

	static int K;
	static int[][] tobni;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tobni = new int[5][8];
		for(int i=1;i<=4;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<8;++j) {
				if(temp[j]=='1')tobni[i][j]=1;
			}
		}
		K = sc.nextInt();
		int[][] order = new int[K][2];
		for(int i=0;i<K;++i) {
			order[i][0] = sc.nextInt();
			order[i][1] = sc.nextInt();
		}
		for(int i=0;i<K;++i) {
			boolean[] flag = new boolean[5];
			int[] ro = new int[5];
			switch (order[i][0]) {
			case 1:
				flag[1] = true;
				ro[1] = order[i][1];
				if(tobni[1][2]!=tobni[2][6]) {
					flag[2] = true;
					ro[2] = -1*order[i][1];
					if(tobni[2][2]!=tobni[3][6]) {
						flag[3] = true;
						ro[3] = order[i][1];
						if(tobni[3][2]!=tobni[4][6]) {
							flag[4]=true;
							ro[4] = -1*order[i][1];
						}
					}
				}
				break;
			case 2:
				flag[2] = true;
				ro[2] = order[i][1];
				if(tobni[2][6]!=tobni[1][2]) {
					flag[1] = true;
					ro[1] = -1*order[i][1];
				}
				if(tobni[2][2]!=tobni[3][6]) {
					ro[3] = -1*order[i][1];
					flag[3] = true;
					if(tobni[3][2]!=tobni[4][6]) {
						flag[4]=true;
						ro[4] = order[i][1];
					}
				}
				break;
			case 3:
				flag[3] = true;
				ro[3] = order[i][1];
				if(tobni[3][6]!=tobni[2][2]) {
					flag[2] = true;
					ro[2] = -1*order[i][1];
					if(tobni[2][6]!=tobni[1][2]) {
						flag[1] = true;
						ro[1] = order[i][1];
					}
				}
				if(tobni[3][2]!=tobni[4][6]) {
					ro[4] = -1*order[i][1];
					flag[4]=true;
				}
				break;
			case 4:
				flag[4] = true;
				ro[4] = order[i][1];
				if(tobni[4][6]!=tobni[3][2]) {
					flag[3] = true;
					ro[3]=-1*order[i][1];
					if(tobni[3][6]!=tobni[2][2]) {
						flag[2] = true;
						ro[2]=order[i][1];
						if(tobni[2][6]!=tobni[1][2]) {
							flag[1] = true;
							ro[1]=-1*order[i][1];
						}
					}
				}
				break;
			}
			for(int j=1;j<=4;++j) {
				if(flag[j]) {
					if(ro[j]==1) {
						rotate(tobni[j]);
					}else {
						reverseRotate(tobni[j]);
					}
				}
			}
			for(int k=1;k<=4;++k) {
				for(int j=0;j<8;++j) {
					System.out.print(tobni[k][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		int result = 0;
		for(int i=1;i<=4;++i) {
			if(tobni[i][0]==1) {
				result+=Math.pow(2, i-1);
			}
		}
		System.out.println(result);
		
	}
	private static void rotate(int[] arr) {
		int temp = arr[7];
		arr[7] = arr[6];
		arr[6] = arr[5];
		arr[5] = arr[4];
		arr[3] = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
	}
	private static void reverseRotate(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = arr[3];
		arr[3] = arr[4];
		arr[4] = arr[5];
		arr[5] = arr[6];
		arr[6] = arr[7];
		arr[7] = temp;
	}

}
