import java.util.ArrayList;
import java.util.Scanner;

public class Main12100_2048_easy {

	static int N;
	static int[] num;
	static int[][] map;
	static int result;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		num = new int[5];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(result);
		sc.close();
	}

	private static void dfs(int index) {
		if(index==5) {
			int[][] temp = new int[N][N];
			clone(temp,map);
			for(int i=0;i<num.length;++i) {
				switch (num[i]) {
				case 1:temp =go(temp,"up");break;
				case 2:temp =go(temp,"down");break;
				case 3:temp =go(temp,"right");break;
				case 4:temp =go(temp,"left");break;
				}
			}
			int max = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(temp[i][j]>max)max=temp[i][j];
				}
			}
			result=max>result?max:result;
			return;
		}
		for(int i=1;i<=4;++i) {
			num[index]=i;
			dfs(index+1);
		}
		
	}

	private static void clone(int[][] clo,int[][] arr) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				clo[i][j]=arr[i][j];
			}
		}
	}
	private static int[][] go(int[][] map, String order) {
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0;i<N;++i) {
			list[i]=new ArrayList<Integer>();
		}
		if(order.equals("up")) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<N;++i) {
					if(map[i][j]!=0) {
						list[j].add(map[i][j]);
					}
				}
			}
		}else if(order.equals("down")) {
			for(int j=0;j<N;++j) {
				for(int i=N-1;i>=0;--i) {
					if(map[i][j]!=0) {
						list[j].add(map[i][j]);
					}
				}
			}
		}else if(order.equals("left")) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]!=0) {
						list[i].add(map[i][j]);
					}
				}
			}
		}else if(order.equals("right")) {
			for(int i=0;i<N;++i) {
				for(int j=N-1;j>=0;--j) {
					if(map[i][j]!=0) {
						list[i].add(map[i][j]);
					}
				}
			}
		}
		for(int i=0;i<N;++i) {
			ArrayList<Integer> tList = new ArrayList<>();
			for(int j=0;j<list[i].size();) {
				if(j==list[i].size()-1) {
					tList.add(list[i].get(j));
					break;
				}
				int a = list[i].get(j);
				int b = list[i].get(j+1);
				if(a==b) {
					tList.add(list[i].get(j)*2);
					j+=2;
				}else {
					tList.add(list[i].get(j));
					j++;
				}
			}
			list[i].clear();
			list[i].addAll(tList);
		}
		int[][] temp = new int[N][N];
		if(order.equals("up")) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<list[j].size();++i) {
					temp[i][j]=list[j].get(i);
				}
			}
		}else if(order.equals("down")) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<list[j].size();++i) {
					temp[N-i-1][j]=list[j].get(i);
				}
			}
		}else if(order.equals("left")) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<list[i].size();++j) {
					temp[i][j]=list[i].get(j);
				}
			}
			
			
		}else if(order.equals("right")) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<list[i].size();++j) {
					temp[i][N-j-1]=list[i].get(j);
				}
			}
		}
		return temp;
		
		
		
	}

}
