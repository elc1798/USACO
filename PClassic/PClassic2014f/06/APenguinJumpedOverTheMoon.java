import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class APenguinJumpedOverTheMoon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (
				new FileReader ("APenguinJumpedOverTheMoonIN.txt"));
		
		while (br.ready()) {
			String line = br.readLine();
			String[] tokens = line.split(" ");
			int launch_x = Integer.parseInt(tokens[0]);
			int launch_y = Integer.parseInt(tokens[1]);
			int land_r = Integer.parseInt(tokens[2]);
			int land_x = Integer.parseInt(tokens[3]);
			int land_y = Integer.parseInt(tokens[4]);
			int land_w = Integer.parseInt(tokens[5]);
			int land_h = Integer.parseInt(tokens[6]);
			
			System.out.println(canWeSucceed(launch_x, launch_y, land_r,
											land_x, land_y, land_w, land_h));
		}
		
		br.close();
	}

	public static boolean canWeSucceed(int launch_x, int launch_y, int land_r, int land_x, int land_y, int land_w, int land_h) {

		int x = launch_x;
		int y = launch_y;
		int xcor = land_x;
		int ycor = land_y;
		int r = land_r;
		int w = land_w;
		int h = land_h;

                int[] recTL = {xcor,ycor};
		int[] recTR = {xcor + w, ycor};
		int[] recBL = {xcor, ycor - h};
		int[] recBR = {xcor + w, ycor - h};
		int[] launch = {x, y};


		if ( (x >= xcor) && (x <= xcor + w) && ( y <= ycor) && (y >= ycor - h) ) {
			return true;
		}
		if ((distance(launch,recTL) <= r) ||
		(distance(launch, recTR) <= r) ||
		(distance(launch, recBL) <= r) ||
		(distance(launch, recBR) <= r)) {
			return true;
		}
		
		if ( ((x <= xcor) && ( y <= ycor) && (y >= ycor -h)  && ((x + r) >= xcor)) ||
		((x >= xcor + w) && ( y <= ycor) && (y >= ycor - h) && ((x - r) <= xcor + w)) ||
		((y <= ycor - h) && ( x >= xcor) && (x <= xcor + h) && ((y + r) >= ycor - h)) ||
		((y >= ycor) && ( x >= xcor) && (x <= xcor + h) && ((y - r) <= ycor)) ) {
			return true;
		}

		else {
			return false;
		}
	}

	public static double distance(int[] cor1, int[] cor2) {
		return Math.sqrt((cor1[0] - cor2[0])*(cor1[0] - cor2[0]) + (cor1[1] - cor2[1])*(cor1[1] - cor2[1]));
	}
}
