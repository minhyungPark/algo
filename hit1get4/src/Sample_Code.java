import java.net.*;
import java.io.*;
public class Sample_Code {

	// User and Game Server Information
	static final String NICKNAME = "자바";
	static final String HOST = "127.0.0.1";
	static final int PORT = 1447; // Do not modify
	
	// predefined variables(Do not modify these values)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 124;
	static final int NUMBER_OF_BALLS = 5;
	static final int[][] HOLES = {{0, 0}, {130, 0}, {260, 0}, {0, 130}, {130, 130}, {260, 130}};
	
	public static int distance(int xx,int yy,int x,int y) {
		return (int)Math.sqrt((xx-x)*(xx-x)+(yy-y)*(yy-y));
	}
	
	public static void main(String[] args) {
		
		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];
//		int[][][] round = new int[6][20][2];
//		round[0][0][0] = 75;round[0][0][1] = 100;
//		round[1][0][0] = 75;round[1][0][1] = 100;round[1][1][0] = 248;round[1][1][1] = 133;
//		round[2][0][0] = 48;round[2][0][1] = 80;round[2][1][0] = 85;round[2][1][1] = 110;round[2][2][0] = 172;round[2][2][1] = 90;
//		round[3][0][0] = 48;round[3][0][1] = 65;round[3][1][0] = 83;round[3][1][1] = 200;round[3][2][0] = 28;round[3][2][1] = 90;
		boolean flag = true;
		String[] r = new String[6];
		r[0] = "65/65/250/120/0/0/0/0/0/0";
		r[1] = "65/65/250/120/10/10/0/0/0/0";
		r[2] = "65/65/125/120/240/125/250/10/0/0";
		r[3] = "65/65/115/110/135/15/125/120/130/5";
		r[4] = "65/65/195/65/0/0/0/0/0/0";
		r[5] = "65/65/195/65/203/57/203/73/211/65";
		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = "9901/" + NICKNAME;
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play.");
			int rr = 0;
			int jj = 0;
			while (socket != null) {
				
				bytes = new byte[1024];
				
				int readByteCount = is.read(bytes);
				recv_data = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("Data Received: " + recv_data);
				String[] split_data = recv_data.split("/");
				if(flag) {
					for(int i=0;i<6;++i) {
						if(r[i].equals(recv_data)) {
							rr=i;
							break;
						}
					}
					flag = false;
				}
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				}
				catch (Exception e) {
					bytes = new byte[1024];
					balls = new int[NUMBER_OF_BALLS][2];
					bytes = "9902/9902".getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}
				
				int angle = 0;
				int power = 100;
//				angle = round[rr][jj][0];
//				power = round[rr][jj][1];
//				++jj;
				int[][] data = new int[split_data.length/2][2];
				for(int i=0;i<split_data.length/2;++i) {
					data[i][0] = Integer.parseInt(split_data[2*i]);
					data[i][1] = Integer.parseInt(split_data[2*i+1]);
				}
				int x = data[0][0];
				int y = data[0][1];
				int xx = 0;
				int yy = 0;
				int dis = distance(xx, yy, x, y);
				System.out.println(dis);
				for(int i=1;i<5;++i) {
					if(data[i][0]!=0||data[i][1]!=0) {
						xx = data[i][0];
						yy = data[i][1];
						break;
					}
				}
				
				int min=Integer.MAX_VALUE;
				int key = 0;
				for(int i=0;i<6;++i) {
					if(min>distance(HOLES[i][0], HOLES[i][1], xx, yy)) {
						min=distance(HOLES[i][0], HOLES[i][1], xx, yy);
						key = i;
					}
				}
				power = (int) ((dis+min)/290.0*200);
				if(power<100)power+=28;
				if(power>150)power-=50;
				int theta = (int) ( Math.acos(((double)(HOLES[key][1]-yy))/min)*180/Math.PI);
				System.out.println(((double)(HOLES[key][1]-yy))/min*180/Math.PI);
				
				int temp = (int) (Math.atan2(yy-y, xx-x)*180/Math.PI);
				if(xx>x&&yy>y) {
					angle =91- temp;
				}else if(xx>x&&yy<y) {
					angle = 88- temp;
				}else if(xx<x&&yy>y) {
					angle = 88- temp;
				}else {
					angle =91- temp;
				}
				String merged_data = angle + "/" + power;
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}
			os.close();
			is.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
