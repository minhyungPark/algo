import java.util.ArrayList;
import java.util.Scanner;

public class Solution_ad2 {

	
	static int[][] map;
	static int[] top;
	static ArrayList<Integer>[] list;
	static int topmax;
	static int A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int[] turn = new int[N];
			for(int i=0;i<N;++i) {
				turn[i]=sc.nextInt();
			}
			list = new ArrayList[6];
			for(int i=0;i<6;++i) {
				list[i] = new ArrayList<Integer>();
			}
			A = 0;
			B = 0;
			map = new int[6][100];
			top = new int[6];
			for(int i=0;i<N;++i) {
				if(i%2==0) {
					drop(turn[i],1);
				}else {
					drop(turn[i],2);
				}
			}
			System.out.println();
			
		}
		
	}
	private static int[] check(int tt) {
		int f1=0;
		int a=0;
		int key1 = 0;
		boolean ff1 = false;
		while(a<=2) {
			f1=0;
			key1 = a;
			for(int i=0;i<6;++i) {
				if(map[i][tt]==1)f1++;
				else break;
			}
			if(f1>=4) {
				ff1 = true;
				break;
			}
			a++;
		}
		int f2=0;
		a=0;
		int key2 = 0;
		boolean ff2 = false;
		while(a<=2) {
			f2=0;
			key2 = a;
			for(int i=0;i<6;++i) {
				if(map[i][tt]==2)f2++;
				else break;
			}
			if(f2>=4) {
				ff2 = true;
				break;
			}
			a++;
		}
		int[] temp = {-1,-1,-1,-1};
		if(ff1) {
			temp[0] = f1;
			temp[1] = key1;
		}
		if(ff2) {
			temp[2] = f2;
			temp[3] = key2;
		}
		return temp;
	}
	
	private static void drop(int pos, int what) {
		int tt= top[pos];
		map[pos][top[pos]++] = what;
		boolean ff = false;
		int f=0;
		int a = 0;
		int key = 0;
		while(a<=2) {
			f=0;
			key = a;
			for(int i=0;i<6;++i) {
				if(map[i][tt]==what)f++;
				else break;
			}
			if(f>=4) {
				ff = true;
				break;
			}
			a++;
		}
		if(ff) {
			for(int i=key;i<key+f;++i) {
				map[i][tt]  = 0;
			}
			if(what==1)	A +=f;
			else B+=f;
			clone1();
			
			
			while(true) {
				if(topmax==0)break;
				for(int i=topmax-1;i>=tt;--i) {
					int[] c = check(i);
					if(c[0]==-1&&c[2]==-1) break;
					if(c[0]!=-1) {
						for(int k=c[1];k<c[1]+c[0];++k) {
							map[k][i]  = 0;
						}
						if(what==1)A+=c[0];
					}
					if(c[2]!=-1) {
						for(int k=c[2];k<c[2]+c[3];++k) {
							map[k][i]  = 0;
						}
						if(what==2)B+=c[0];
					}
					clone1();
				}
				
				
			}
		}
		
	}
	
	private static void clone1() {
		for(int i=0;i<6;++i) {
			for(int j=0;j<top[i];++j) {
				if(map[i][j]!=0)list[i].add(map[i][j]);
			}
		}
		map = new int[6][100];
		for(int i=0;i<6;++i) {
			for(int j=0;j<list[i].size();++j) {
				map[i][j] = list[i].get(j);
			}
			top[i] = list[i].size();
		}
		topmax = 0;
		for(int i=0;i<6;++i) {
			if(topmax<top[i])topmax = top[i];
		}
 		
	}

}