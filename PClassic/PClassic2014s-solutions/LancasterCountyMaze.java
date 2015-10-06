import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LancasterCountyMaze {
	
	public static int[] step(int[] dir, int[] pos, char[][] maze){
		
		if(maze[pos[0] + dir[1]][pos[1] - dir[0]] != '#'){
			return new int[] {dir[1], -dir[0]};
		}
		else if(maze[pos[0] + dir[0]][pos[1] + dir[1]] != '#'){
			return dir;	
		}
		else{
			return new int[] {-dir[1], dir[0]};
		}
	}
	
	public static boolean solveMaze(char[][] maze){
		int[] pos = {0,1};
		int[] dir = {1,0};
		try{
			
			while(pos[0] != maze.length - 1 || pos[1] != maze.length - 2){
				
				int[] newDir = step( dir, pos, maze);
				if( (dir[0] == newDir[0] && dir[1] == newDir[1]) ||
						(dir[1] == newDir[0] && -dir[0] == newDir[1])){
					pos = new int[] {pos[0] + newDir[0], pos[1] + newDir[1]};
				}
				
				dir = newDir;
			}

			return true;
		}catch(IndexOutOfBoundsException e){
			return false;
		}
		
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
			new FileReader("LancasterCountyMazeIN.txt"));
		
		String next = reader.readLine();
		
	
		while(reader.ready()){
			char[][] maze = new char[next.length()][next.length()];
			int i = 0;
			int j = 0;
			while(!next.equals("n")){
				for(char c : next.toCharArray()){
					maze[i][j] = c;
					j++;
				}
				i++;
				j = 0;
				next = reader.readLine();
			}
			System.out.println(solveMaze(maze));
			
			next = reader.readLine();
		}
		
		reader.close();

	}

}
