import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class crossword {

	private static char[][] board;

	public static ArrayList<String> analyze(){
		ArrayList<String> clues = new ArrayList<String>();
		boolean added = false;
		for (int i = 1; i < board.length; i++){
			for (int k = 1; k < board[0].length; k++){
				try {
					if (board[i][k - 1] == '#' && board[i][k] == '.' && board[i][k + 1] == '.' && board[i][k + 2] == '.'){
						clues.add(new String("" + i + " " + k));
						added = true;
					}
				} catch(Exception e){}
				try {
					if (board[i - 1][k] == '#' && board[i][k] == '.' && board[i + 1][k] == '.' && board[i + 2][k] == '.'){
						if (!added) {
							clues.add(new String("" + i + " " + k));
						}
					}
				} catch(Exception e){}
				added = false;
			}
		}
		return clues;
	}

	public static void main(String[] args){
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new Scanner(new File("crosswords.in"));
			outputStream = new PrintWriter("crosswords.out" , "UTF-8");
		} catch(Exception e){
			System.exit(0);
		}
		board = new char[Integer.parseInt(inputStream.next()) + 1][Integer.parseInt(inputStream.next()) + 1];
		for (int i = 0; i < board.length; i++){
			if (i == 0) {
				for (int k = 0; k < board[i].length; k++){
					board[i][k] = '#';
				}
			} else {
				String s = "#" + inputStream.next();
				for (int k = 0; k < board[i].length; k++){
					board[i][k] = s.charAt(k);
				}
			}
		}
		ArrayList<String> out = analyze();
		outputStream.println("" + out.size());
		for (int i = 0; i < out.size(); i++){
			outputStream.println("" + out.get(i));
		}
		outputStream.close();
	}

}
