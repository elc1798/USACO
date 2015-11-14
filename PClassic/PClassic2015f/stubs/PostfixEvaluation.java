import java.util.*;
import java.io.File;
import java.io.IOException;
public class PostfixEvaluation{
		
	public static void main(String[] args) throws IOException{
		String expression = ""; 
	    Scanner in = new Scanner(new File("PostfixEvaluationIN.txt"));
		while(in.hasNext()){
			expression = in.nextLine();
			
			System.out.printf("%.1f\n", solve(expression));
		}
	}
	
	public static double solve (String expression){
		return 0.0;
	}
}
