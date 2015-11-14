import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class DiglettsCave {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"DiglettsCaveIN.txt"));

		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			int r = Integer.parseInt(data[0]);
			int c = Integer.parseInt(data[1]);
			int sr = Integer.parseInt(data[2]);
			int sc = Integer.parseInt(data[3]);
			int er = Integer.parseInt(data[4]);
			int ec = Integer.parseInt(data[5]);
			int[][] cave = new int[r][c];
			for (int row = 0; row < r; row++) {
				String line = br.readLine();
				for (int col = 0; col < c; col++) {
					cave[row][col] = Integer.parseInt(""+line.charAt(col));
				}
			}
			System.out.println(minimumSmashes(cave, sr, sc, er, ec));
		}
		br.close();

	}
	
	public static int minimumSmashes(int[][] cave, int sr, int sc,
												   int er, int ec) {
		
		PriorityQueue<QueueElem> queue = new PriorityQueue<QueueElem>();
		int rows = cave.length;
		int cols = cave[0].length;
		int[][] dists = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (r == sr && c == sc) {
					queue.add(new QueueElem(0, r, c));
					dists[r][c] = 0;
				} else {
					queue.add(new QueueElem(-1, r, c));
					dists[r][c] = -1;
				}
				
			}
		}
		while(!queue.isEmpty()) {
			QueueElem p = queue.poll();
			Set<QueueElem> neighbors = p.neighbors(rows, cols);
			int cur_dist = dists[p.r][p.c];
			if (cur_dist == -1 || cave[p.r][p.c] == 2) {
				continue;
			}
						
			for (QueueElem n: neighbors) {
				int ndist = cur_dist;
				if (cave[n.r][n.c] == 2) continue;
				if (cave[n.r][n.c] == 1) ndist++;
				int dist = dists[n.r][n.c];
				if (dist > ndist || dist == -1) {
					dists[n.r][n.c] = ndist;
					queue.remove(n);
					n.k = ndist;
					queue.add(n);
				}
			}
			
		}
		return dists[er][ec];
	}
	private static class QueueElem implements Comparable<QueueElem> {
		public int k, r, c;
		
		public QueueElem(int K, int R, int C) {
			k = K;
			r = R;
			c = C;
		}
		@Override
		public int compareTo(QueueElem arg0) {
			if (k < 0)
				return 1;
			if (arg0.k < 0)
				return -1;
			return k - (arg0).k;
		}
		@Override
		public boolean equals(Object arg0) {
			return (r == ((QueueElem)arg0).r) && (c == ((QueueElem)arg0).c); 
		}
		public Set<QueueElem> neighbors(int rows, int cols) {
			Set<QueueElem> n = new HashSet<QueueElem>(4);
			if (r -1 >= 0) {
				n.add(new QueueElem(-1, r-1, c));
			}
			if (r + 1 < rows) {
				n.add(new QueueElem(-1, r+1, c));
			}
			if (c-1 >= 0) {
				n.add(new QueueElem(-1, r, c-1));
			}
			if (c + 1 < cols) {
				n.add(new QueueElem(-1, r, c+1));
			}						
			return n;
		}
		public String toString() {
			return k + " " + r + " " + c;
		}
	}
	
	
	
}
