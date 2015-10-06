import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class NestAndBreakfast {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new FileReader 
												("NestAndBreakfastIN.txt"));
		
		while (br.ready()) {
			String line = br.readLine();
			
			String[] data = line.split(" ");
			int num = Integer.parseInt(data[0]);
			int[] reservations = new int[num];
			for (int i = 0; i < num; i++) {
				reservations[i] = Integer.parseInt(data[i+1]);
			}
			
			System.out.println(maxReservations(reservations));
		}
		
		
		br.close ();
	}

	private static long maxReservations(int[] reservations) {
		long currMax = 0;
		int index = 0;
		int[] ary = new int[reservations.length + 4];
		for (int i = 0; i < reservations.length; i++){
			ary[i + 2] = reservations[i];
		}
		while (sum(ary) > 0){
			index = maxindex(ary);
			if (ary[index] > ary[index + 1] + ary[index - 1]) {
				currMax += ary[index];
				ary[index - 1] = 0;
				ary[index] = 0;
				ary[index + 1] = 0;
			} else if (ary[index] + ary[index - 2] + ary[index + 2] > ary[index - 1] + ary[index + 1]){
				currMax += ary[index];
				ary[index - 1] = 0;
				ary[index] = 0;
				ary[index + 1] = 0;
			} else {
				currMax += ary[index - 1] + ary[index + 1];
				ary[index - 2] = 0;
				ary[index - 1] = 0;
				ary[index] = 0;
				ary[index + 1] = 0;
				ary[index + 2] = 0;
			}
		}
		return currMax;
        }

	private static int maxindex(int[] ary){
		int currMax = 0;
		int index = 0;
		for (int i = 0; i < ary.length; i++){
			if (ary[i] > currMax){
				currMax = ary[i];
				index = i;
			}
		}
		return index;
	}

	private static int sum(int[] ary){
		int sum = 0;
		for (int i = 0; i < ary.length; i++){
			sum += ary[i];
		}
		return sum;
	}

}
