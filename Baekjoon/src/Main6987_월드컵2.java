import java.util.Scanner;

public class Main6987_월드컵2 {
	
	static int[][] play;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=4;++t) {
			play = new int[6][3];
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
			
		}
		System.out.println(sb.toString());

	}


}
