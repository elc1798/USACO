import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class MiddleFather {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader (new FileReader ("MiddleFatherIn.txt"));
		
		while (br.ready()) {
			String[] data = br.readLine().split(" ");
		
			FoundingFather[] ffs = new FoundingFather[data.length/2];
			for (int i = 0; i < data.length-1; i+=2) {
				
				ffs[i/2] = new FoundingFather(data[i], Integer.parseInt(data[i+1]));
				
			}
			
			System.out.println(middleFather(ffs));
		}
		
		
		br.close ();
		
		
	
	}
	
	public static String middleFather(FoundingFather[] ffs) {
		Comparator<FoundingFather> compare = new Comparator<FoundingFather>() {
			public int compare(FoundingFather f1, FoundingFather f2) {
				return f1.age - f2.age;
			}
		};
		
		List<FoundingFather> ffsList = new ArrayList<FoundingFather>(Arrays.asList(ffs));
		
		Collections.sort(ffsList, compare);
		
		return ffsList.get(ffs.length/2).name;
		
	}
	private static class FoundingFather {
		
		public String name;
		public int age;
		
		public FoundingFather(String n, int a) {
			age = a;
			name = n;
		}
		
		public String toString() {
			return name + " " + age;
		}
	}
}
