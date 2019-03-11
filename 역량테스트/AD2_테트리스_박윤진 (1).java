package algorithmTil0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//12:46~
public class AD2_테트리스_박윤진 {
	
	private static class List{
		ArrayList<Integer> l=new ArrayList<Integer>();

		public List(){
			super();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List[] list = new List[6];
		int[] heights;
		int mxH;
		int cnt = 0;
		int cntA = 0, cntB;
		boolean change=false;
		
		for(int t=1;t<=T;++t) {
			cntA=cntB=0;
			heights = new int[6];
			//make and initialize list
			for(int i=0;i<6;++i) list[i] = new List();
			
			int N = Integer.parseInt(br.readLine());
			String[] ss = br.readLine().split(" ");
			
			for(int n=0;n<N;++n) {
				// push the block
				//1ilsang : 1, 2ilsang : 2
				list[Integer.parseInt(ss[n])].l.add(((n&1)==0)?1:2);
				change = true;
				
				//continue until there are no blocks to erase
				while(change==true) {
					change=false;
					mxH=Integer.MIN_VALUE;
					//find the max height
					for(int i=0;i<6;++i) {
						heights[i]=list[i].l.size();
						if(heights[i]>mxH) mxH=heights[i];
					}

					//if there are more than 4 blocks in a row, change the number to 0
					for(int j=0;j<mxH;j++) {
						for(int i=0;i<5;++i) {
							cnt=1;
							int st=i;
							while(st<5 && j<heights[st] && j<heights[st+1] && list[st].l.get(j)==list[st+1].l.get(j)) {
								cnt+=1;
								st+=1;
							}
							
							if(cnt>=4) {
								change=true;
								if(((n&1)==0) && list[i].l.get(j)==1) cntA+=cnt;
								else if(((n&1)!=0) && list[i].l.get(j)==2) cntB+=cnt;
								// change the selected blocks to 0
								for(int k=st;k>st-cnt;--k) list[k].l.set(j, 0);
								//get out and go to next row
								break;
							}
						}
					}
					
					// get rid of all the blocks which has 0 value
					if(change==true) {
						for(int j=0;j<mxH;++j) {
							for(int i=0;i<6;++i) {
								if(j<list[i].l.size()&& list[i].l.get(j)==0) list[i].l.remove(j);
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+Math.abs(cntA-cntB));
		}

	}

}
