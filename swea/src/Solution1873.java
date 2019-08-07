import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {

	static int N,M;
	static char[][] map;
	static int[] tank;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1873.txt"));
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;++t) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			tank = new int[2];
			for(int i=0;i<N;++i) {
				char[] temp = bf.readLine().toCharArray();
				for(int j=0;j<M;++j) {
					map[i][j] = temp[j];
					if(map[i][j]=='^'||map[i][j]=='<'||map[i][j]=='v'||map[i][j]=='>') {
						tank[0]=i;
						tank[1]=j;
					}
				}
			}	// 입력 끝
			int len = Integer.parseInt(bf.readLine());
			char[] order = bf.readLine().toCharArray();
			for(int i=0;i<order.length;++i) {
				switch (order[i]) {
				case 'U':upMove();break;
				case 'D':downMove();break;
				case 'L':leftMove();break;
				case 'R':rightMove();break;
				case 'S':shoot();break;
				default:break;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString().trim());
		}
	}
	private static void shoot() {
		int x=tank[0];
		int y=tank[1];
		switch (map[x][y]) {
		case '^':
			for(int i=x-1;i>=0;--i){
				if(map[i][y]=='*'||map[i][y]=='#') {
					if(map[i][y]=='*')map[i][y]='.';
					break;
				}
			}
			break;
		case 'v':
			for(int i=x+1;i<N;++i){
				if(map[i][y]=='*'||map[i][y]=='#') {
					if(map[i][y]=='*')map[i][y]='.';
					break;
				}
			}
			break;
		case '<':
			for(int i=y-1;i>=0;--i){
				if(map[x][i]=='*'||map[x][i]=='#') {
					if(map[x][i]=='*')map[x][i]='.';
					break;
				}
			}
			break;
		case '>':
			for(int i=y+1;i<M;++i){
				if(map[x][i]=='*'||map[x][i]=='#') {
					if(map[x][i]=='*')map[x][i]='.';
					break;
				}
			}
			break;
		default:
			break;
		}
		
	}
	private static void rightMove() {
		int x = tank[0];
		int y = tank[1];
		map[x][y] = '>';
		int ny = y+1;
		if(ny>=M||map[x][ny]!='.')return;
		map[x][y] = '.';
		map[x][ny] = '>';
		tank[1] = ny;
	}
	private static void leftMove() {
		int x = tank[0];
		int y = tank[1];
		map[x][y] = '<';
		int ny = y-1;
		if(ny<0||map[x][ny]!='.')return;
		map[x][y] = '.';
		map[x][ny] = '<';
		tank[1] = ny;
	}
	private static void downMove() {
		int x = tank[0];
		int y = tank[1];
		map[x][y] = 'v';
		int nx = x+1;
		if(nx>=N||map[nx][y]!='.')return;
		map[x][y] = '.';
		map[nx][y] = 'v';
		tank[0] = nx;
	}
	private static void upMove() {
		int x = tank[0];
		int y = tank[1];
		map[x][y] = '^';
		int nx = x-1;
		if(x-1<0||map[nx][y]!='.')return;
		map[x][y] = '.';
		map[nx][y] = '^';
		tank[0] = nx;
	}
}
