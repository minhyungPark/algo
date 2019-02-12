package com.ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//6
//1 1 10
//2 5 6
//3 13 15
//4 14 17
//5 8 14
//6 3 12

public class MeetingAssignment {

	private static class MeetingRoom implements Comparable<MeetingRoom>{
		int num;
		int start;
		int end;
		MeetingRoom(int num,int start,int end){
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(MeetingRoom o) {
			if(this.end!=o.end) {
				return this.end - o.end;
			}else {
				return this.start - o.start;
			}
		}
		@Override
		public String toString() {
			return "MeetingRoom [num=" + num + ", start=" + start + ", end=" + end + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		MeetingRoom[] m = new MeetingRoom[N];
		StringTokenizer st = null;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			m[i] = new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(m);
		ArrayList<MeetingRoom> list = new ArrayList<>();
		list.add(m[0]);
		for(int i=1;i<N;++i) {
			if(m[i].start>=list.get(list.size()-1).end) {
				list.add(m[i]);
			}
		}
		System.out.println(list.size());
		for(int i=0;i<list.size();++i) {
			System.out.print(list.get(i).num+" ");
		}
//		System.out.println(Arrays.toString(m));
		
		
	}

}
