import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Cheesesteaks {

	private static int[][] types = {{2, 2, 5}, {2, 4, 6}, {3, 3, 7}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ("CheesesteaksIn.txt"));
		
		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			int c = Integer.parseInt(data[0]);
			int s = Integer.parseInt(data[1]);
			int r = Integer.parseInt(data[2]);
			System.out.println(maximizeProfits(c, s, r));
		}
		br.close();
	}
	
	public static int maximizeProfits(int cheese, int steak, int rolls) {
		
		int r = rolls, c = cheese, s = steak;
		int p = 0;
		
		while (r > 0 && c > 0 && s > 0) {
			
			int profits[] = {profitsFrom(0, c, s, r), profitsFrom(1, c, s, r),
					profitsFrom(2, c, s, r)};
		
			int max = 0, index = 0;
			for (int i = 0; i < 3; i++) {
				if (max < profits[i]) {
					max = profits[i];
					index= i;
				}
			}
			
			r--;
			c -= types[index][0];
			s -= types[index][1];
			p += types[index][2];
			
			
		}
		//System.out.println(c + " " + s + " " + r);
		
		return p;
		
	}
	
	private static int profitsFrom(int type, int cheese, int steak, int rolls) {
		
		int rollsByCheese = cheese/types[type][0];
		int rollsBySteak = steak/types[type][1];
		
		return types[type][2]*Math.min(rollsByCheese, Math.min(rollsBySteak, rolls));
		
	}

}
