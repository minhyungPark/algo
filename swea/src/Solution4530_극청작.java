import java.util.Scanner;

public class Solution4530_극청작 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long[][] arr = new long[13][10];
		arr[0][4] = arr[0][5] =arr[0][6] =arr[0][7] =arr[0][8] =arr[0][9] =1;
		for(int i=1;i<13;++i) {
			long temp = arr[i-1][9];
			arr[i][0] = temp;
			for(int j=1;j<=3;++j) {
				arr[i][j] = arr[i][j-1]+temp;
			}
			arr[i][4] = (long) (Math.pow(10, i)+arr[i][3]); 
			for(int j=5;j<10;++j) {
				arr[i][j]=temp+arr[i][j-1];
			}
		}
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			int Ajali = 0;
			int minusA = 0;
			int minusB = 0;
			if(A<0) {
				minusA = 1;
				A *=-1;
			}
			if(B<0) {
				minusB = 1;
				B*=-1;
			}
			for(int i=1;i<=13;++i) {
				long temp = (long) (A/Math.pow(10, i));
				if(temp==0) {
					Ajali = i-1;
					break;
				}
			}
			int Bjali = 0;
			for(int i=1;i<=13;++i) {
				long temp = (long) (B/Math.pow(10, i));
				if(temp==0) {
					Bjali = i-1;
					break;
				}
			}
			long ta = A;
			long tb = B;
			long aaa = 0;
			long bbb = 0;
			while(Ajali>=0) {
				int aa = (int) (ta/Math.pow(10,Ajali));
				ta = (long) (ta%Math.pow(10,Ajali));
				if(aa==0) {
					Ajali--;
					continue;
				}
				aaa += arr[Ajali--][aa-1];
			}
			while(Bjali>=0) {
				int bb = (int) (tb/Math.pow(10,Bjali));
				tb = (long) (tb%Math.pow(10,Bjali));
				if(bb==0) {
					Bjali--;
					continue;
				}
				bbb += arr[Bjali--][bb-1];
			}
			A -= aaa;
			B -= bbb;
			System.out.println(A+" "+B);
			long result = 0;
			if(minusA==0&&minusB==0) {
				result = B-A;
			}else if(minusA==1&&minusB==1){
				result = A-B;
			}else {
				result = B+A-1;
			}
			System.out.println("#"+t+" "+result);
		}

	}

}
