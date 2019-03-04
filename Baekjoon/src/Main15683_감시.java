import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main15683_감시 {
	private static class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int N,M;
	static int[][] map;
	static int[] cctv1,cctv2,cctv3,cctv4;
	static ArrayList<Node>[] cctvList;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctvList = new ArrayList[6];
		for(int i=0;i<6;++i) {
			cctvList[i] = new ArrayList<Node>();
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j]=sc.nextInt();
				for(int k=1;k<=5;++k) {
					if(map[i][j]==k) {
						cctvList[k].add(new Node(i,j));
						break;
					}
				}
			}
		}
		result= Integer.MAX_VALUE;
		cctv1 = new int[cctvList[1].size()];
		cctv2 = new int[cctvList[2].size()];
		cctv3 = new int[cctvList[3].size()];
		cctv4 = new int[cctvList[4].size()];
		for(int i=0;i<cctvList[5].size();++i) {
			cctv5(i);
		}
		dfs1(0);
		
		
		/*for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}*/
		System.out.println(result);
	}

	private static void dfs1(int index) {
		if(index==cctvList[1].size()) {
			dfs2(0);
			return;
		}
		
		for(int i=1;i<=4;++i) {
			cctv1[index] =i;
			dfs1(index+1);
		}
	}

	private static void dfs2(int index) {
		if(index==cctvList[2].size()) {
			dfs3(0);
			return;
		}
		
		for(int i=1;i<=2;++i) {
			cctv2[index] = i;
			dfs2(index+1);
		}
	}

	private static void dfs3(int index) {
		if(index==cctvList[3].size()) {
			dfs4(0);
			return;
		}
		
		for(int i=1;i<=4;++i) {
			cctv3[index] =i;
			dfs3(index+1);
		}

	}

	private static void dfs4(int index) {
		if(index==cctvList[4].size()) {
			int[][] temp = new int[N][M];
			clone(map,temp);
			for(int i=0;i<cctv1.length;++i) {
				cctv1(cctv1[i],i,temp);
			}
			for(int i=0;i<cctv2.length;++i) {
				cctv2(cctv2[i],i,temp);
			}
			for(int i=0;i<cctv3.length;++i) {
				cctv3(cctv3[i],i,temp);
			}
			for(int i=0;i<cctv4.length;++i) {
				cctv4(cctv4[i],i,temp);
			}
			int sum = 0;
			for (int[] is : temp) {
				for (int is2 : is) {
					if(is2==0)sum++;
				}
			}
			if(sum<result)result = sum;
			
			return;
		}
		
		for(int i=1;i<=4;++i) {
			cctv4[index] =i;
			dfs4(index+1);
		}
	}

	private static void cctv5(int index) {
		Node current = cctvList[5].get(index);
		for(int i=current.x-1;i>=0;--i) {
			if(map[i][current.y]==6)break;
			if(map[i][current.y]!=0)continue;
			map[i][current.y] = -1;
		}
		for(int i=current.x+1;i<N;++i) {
			if(map[i][current.y]==6)break;
			if(map[i][current.y]!=0)continue;
			map[i][current.y] = -1;
		}
		for(int i=current.y-1;i>=0;--i) {
			if(map[current.x][i]==6)break;
			if(map[current.x][i]!=0)continue;
			map[current.x][i] = -1;
		}
		for(int i=current.y+1;i<M;++i) {
			if(map[current.x][i]==6)break;
			if(map[current.x][i]!=0)continue;
			map[current.x][i] = -1;
		}
	}

	private static void cctv4(int dir,int index,int[][] arr) {
		Node current = cctvList[4].get(index);
		if(dir==1) {//상,좌,우
			//상
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//좌
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
			//우
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}else if(dir==2) {//하,좌,우
			//좌
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
			//우
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
			//하
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
		}else if(dir==3) {//좌상하
			//좌
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
			//상
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//하
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
		}else if(dir==4) {//우상하
			//우
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
			//상
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//하
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
		}
	}

	private static void cctv3(int dir,int index,int[][] arr) {
		Node current = cctvList[3].get(index);
		if(dir==1) {
			//상
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//좌
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}else if(dir==2) {
			//상
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//우
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}else if(dir==3) {
			//하
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//좌
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}else if(dir==4) {
			//하
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			//우
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}
		
	}

	private static void cctv2(int dir,int index,int[][] arr) {
		Node current = cctvList[2].get(index);
		if(dir==1) {
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
		}else if(dir==2) {
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}
	}

	private static void cctv1(int dir,int index,int[][] arr) {
		Node current = cctvList[1].get(index);
		if(dir==1) {	//상
			for(int i=current.x-1;i>=0;--i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
		}else if(dir==2) {	//하
			for(int i=current.x+1;i<N;++i) {
				if(arr[i][current.y]==6)break;
				arr[i][current.y] = -1;
			}
		}else if(dir==3) {	//좌
			for(int i=current.y-1;i>=0;--i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}else if(dir==4) {	//우
			for(int i=current.y+1;i<M;++i) {
				if(arr[current.x][i]==6)break;
				arr[current.x][i] = -1;
			}
		}
	}

	private static void clone(int[][] arr,int[][] target) {
		
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				target[i][j]=arr[i][j];
			}
		}
	}
	
}
