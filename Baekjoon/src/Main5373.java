import java.util.Scanner;

public class Main5373 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int T = sc.nextInt();
		/*
		for(int t=1;t<=T;++t) {
			
		}*/
		
		char[][] up = {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
		char[][] down = {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
		char[][] front = {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
		char[][] back = {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
		char[][] left = {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
		char[][] right = {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
		int N = sc.nextInt();
		for(int n=0;n<N;++n) {
			char[] dir = sc.next().toCharArray();
			switch (dir[0]) {
			case 'U':
				if(dir[1]=='+')plusRotate(up,back[0],right[0],front[0],left[0]);
				else if(dir[1]=='-')minusRotate(up,back[0],right[0],front[0],left[0]);
				break;
			case 'D':
				if(dir[1]=='+')plusRotate(down,front[2],right[2],back[2],left[2]);
				else if(dir[1]=='-')minusRotate(up,front[2],right[2],back[2],left[2]);
				break;
			case 'F':
				if(dir[1]=='+')plusRotate(front,up[2],right,down,left);
				else if(dir[1]=='-')minusRotate(front,up,right,down,left);
				break;
			case 'B':
				if(dir[1]=='+')plusRotate(back,up,left,down,right);
				else if(dir[1]=='-')minusRotate(back,up,left,down,right);
				break;
			case 'L':
				if(dir[1]=='+')plusRotate(left,up,front,down,back);
				else if(dir[1]=='-')minusRotate(left,up,front,down,back);
				break;
			case 'R':
				if(dir[1]=='+')plusRotate(right,up,back,down,front);
				else if(dir[1]=='-')minusRotate(right,up,back,down,front);
				break;
			default:
				break;
			}
		}
		for (char[] cs : up) {
			for (char c : cs) {
				System.out.print(c);
			}
			System.out.println();
		}
		
		/*
		char temp;
		temp = up[0][0];
		up[0][0] = up[1][0];
		up[1][0] = up[2][0];
		up[2][0] = up[2][1];
		up[2][1] = up[2][2];
		up[2][2] = up[1][2];
		up[1][2] = up[0][2];
		up[0][2] = up[0][1];
		up[0][1] = temp;
		
		*/
		
	}

	private static void minusRotate(char[][] me, char[] a, char[] b, char[] c, char[] d) {
		char temp = me[0][0];
		me[0][0] = me[0][1];
		me[0][1] = me[0][2];
		me[0][2] = me[1][2];
		me[1][2] = me[2][2];
		me[2][2] = me[2][1];
		me[2][1] = me[2][0];
		me[2][0] = me[1][0];
		me[1][0] = temp;
		
		char[] tem = a;
		a=b;
		b=c;
		c=d;
		d=tem;
	}

	private static void plusRotate(char[][] me, char[]a, char[] b, char[] c, char[] d) {
		char temp = me[0][0];
		me[0][0] = me[1][0];
		me[1][0] = me[2][0];
		me[2][0] = me[2][1];
		me[2][1] = me[2][2];
		me[2][2] = me[1][2];
		me[1][2] = me[0][2];
		me[0][2] = me[0][1];
		me[0][1] = temp;
		
		char[]tem = b;
		b = a;
		a = d;
		d = c;
		c = tem;
	}

}
