import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

class cow {

	public int pos = 0;
	public int sp = 0;

	public cow(int position , int speed) {
		pos = position;
		sp = speed;
	}

}

public class cowjog {

	public static int remainingGroups(cow[] race) {
		int groups = 1;
		for (int i = race.length - 1; i > 0; i--) {
			if (race[i - 1].sp > race[i].sp) {
				race[i - 1].sp = race[i].sp;
				race[i - 1].pos = race[i].pos - 1;
				i++;
			}
		}
		for (int i = 0; i < race.length - 1; i++) {
			if (race[i].sp != race[i + 1].sp || race[i].pos + 1 != race[i + 1].pos) {
				groups++;
			}
		}
		return groups;
	}

	public static void main(String[] args) {
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new Scanner(new File("cowjog.in"));
			outputStream = new PrintWriter("cowjog.out" , "UTF-8");
		} catch(Exception e){
			System.exit(0);
		}
		cow[] hoard = new cow[Integer.parseInt(inputStream.next())];
		for (int i = 0; i < hoard.length && inputStream.hasNext(); i++) {
			hoard[i] = new cow(Integer.parseInt(inputStream.next()) , Integer.parseInt(inputStream.next()));
		}
		int g = remainingGroups(hoard);
		outputStream.println("" + g);
		outputStream.close();
	}

}
