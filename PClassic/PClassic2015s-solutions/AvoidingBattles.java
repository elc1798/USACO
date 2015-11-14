import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Point {
  int x;
  int y;
  Point(int a, int b) {x = a; y = b;}
}

public class AvoidingBattles {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("AvoidingBattlesIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int m = Integer.parseInt(data[0]);
      int n = Integer.parseInt(data[1]);
      char[][] map = new char[m][n];
      for (int i = 0; i < m; i++) {
        map[i] = br.readLine().toCharArray();
      }
      System.out.println(canAvoidBattles(m, n, map));
    }
    br.close();
  }

  public static void fillSight (int m, int n, char[][] map, int sx, int sy, int dx, int dy) {
    int tx = sx;
    int ty = sy;
    for (;;) {
      tx += dx;
      ty += dy;
      if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
        break;
      }
      if (map[ty][tx] != '.' && map[ty][tx] != ',') {
        break;
      }
      map[ty][tx] = ',';
    }
    return;
  }
  public static void flood(int m, int n, char[][] map) {
    Queue<Point> q = new LinkedList<Point>();
    q.add(new Point(0,0));
    map[0][0] = '/';
    while (!q.isEmpty()) {
      Point p = q.poll();
      int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
      for (int i = 0; i < 4; i++) {
        int nx = p.x + delta[i][0];
        int ny = p.y + delta[i][1];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }
        if (map[ny][nx] != '.') {
          continue;
        }
        map[ny][nx] = '/';
        q.add(new Point(nx, ny));
      }
    }
    return;
  }

  public static boolean canAvoidBattles(int m, int n, char[][] map) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == '<') {
          fillSight(m,n,map,j,i,-1,0);
        } else if (map[i][j] == '>') {
          fillSight(m,n,map,j,i,1,0);
        } else if (map[i][j] == '^') {
          fillSight(m,n,map,j,i,0,-1);
        } else if (map[i][j] == 'v') {
          fillSight(m,n,map,j,i,0,1);
        }
      }
    }
    flood(m,n,map);
    /*for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%c", map[i][j]);
      }
      System.out.printf("\n");
    }*/
    return (map[m-1][n-1] == '/');
  }
}
