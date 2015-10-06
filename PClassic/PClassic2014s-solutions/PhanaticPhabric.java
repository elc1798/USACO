import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PhanaticPhabric {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new FileReader ("PhabricIn.txt"));
		
		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			int[] people = new int[data.length];
			for (int i = 0; i < people.length; i++) {
				people[i] = Integer.parseInt(data[i]);
			}
			System.out.println(phabric(people));
		}
		
		
		br.close ();
	}
	
	public static int phabric(int[] people) {
		double f = 0;
		for (int i = 0; i < people.length-1; i+= 2) {
			int h = people[i];
			int w = people[i+1];
			f += (39*w*w*h + 80*w*w*w)/100000.0;
		}
		return (int)f;
	}

}
