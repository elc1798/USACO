import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ProfessorOak {
	
	static boolean relPrime(int a, int b){
		if (b == 0){
			return a == 1;
		} else {
			return relPrime(b, a % b);
		}
	}
	
	public static int professorOak(int lim){
		int count = 0;
		
		for (int n = 2; n <= (int) Math.sqrt(lim); n++){
			for (int x = n + 1; x < 2 * n && n * x <= lim; x++){
				if (relPrime(n, x)){
					count += lim / (n * x);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("ProfessorOakIN.txt"));
		
		while(reader.ready()){
			int i = new Integer(reader.readLine());
			System.out.println(professorOak(i));
		}
		reader.close();
	}
	
}
