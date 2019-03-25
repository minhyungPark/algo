import java.util.Scanner;

public class Main6987_월드컵 {
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=4;++t) {
			int[][] play = new int[6][3];
			boolean flag =true;
			for(int i=0;i<6;++i) {
				play[i][0]= sc.nextInt();
				play[i][1]= sc.nextInt();
				play[i][2]= sc.nextInt();
				if(play[i][0]+play[i][1]+play[i][2]!=5)
					flag = false;
			}
			if(!flag) {
				sb.append("0 ");
				continue;
			}
			int wsum = 0;
			int lsum = 0;
			int draw = 0;
			for(int i=0;i<6;++i) {
				wsum+=play[i][0];
				draw+=play[i][1];
				lsum+=play[i][2];
			}
			if(wsum!=lsum) {
				sb.append("0 ");
				continue;
			}
			if(wsum+(draw/2)!=15) {
				sb.append("0 ");
				continue;
			}
			int[] temp = new int[6];
			for(int i=0;i<6;++i) {
				temp[i]=play[i][1];
			}
			if(!drawW(temp)) {
				sb.append("0 ");
				continue;
			}
			/*int[] temp1 = new int[6];
			for(int i=0;i<6;++i) {
				temp[i]=play[i][0];
				temp1[i] = play[i][2];
			}
			if(!winW(temp,temp1)) {
				sb.append("0 ");
				continue;
			}*/
			sb.append("1 ");
		}
		System.out.println(sb.toString());

	}

	private static boolean winW(int[] t1,int[] t2) {
		for(int i=0;i<6;++i) {
			if(t1[i]==0)continue;
			int flag = t1[i];
			boolean[] visited = new boolean[6];
			for(int j=0;j<t1[i];++j) {
				for(int k=0;k<6;++k) {
					if(i==k)continue;
					if(t2[k]>0&&!visited[k]) {
						visited[k]=true;
						flag--;
						t2[k]--;
						break;
					}
				}
			}
			if(flag!=0)return false;
		}
		for(int i=0;i<6;++i) {
			if(t2[i]>0)return false;
		}
		
		return true;
	}

	private static boolean drawW(int[] d) {
		for(int i=0;i<6;++i) {
			if(d[i]==0)continue;
			int flag = d[i];
			boolean[] visited = new boolean[6];
			for(int j=0;j<d[i];++j) {
				for(int k=i+1;k<6;++k) {
					if(d[k]>0&&!visited[k]) {
						visited[k]=true;
						flag--;
						d[k]--;
						break;
					}
				}
			}
			if(flag!=0)return false;
			if(flag==0)d[i]=0;
		}
		for(int i=0;i<6;++i) {
			if(d[i]>0)return false;
		}
		
		return true;
	}

}
