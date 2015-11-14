import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Ferry {
  int startIsland;
  int endIsland;
  int ferryCost;
  Ferry(){}
}

class Vertex implements Comparable<Vertex> {
  int id;
  int minDist;
  Vertex(int i,int m) {
    id = i;
    minDist = m;
  }
  public int compareTo(Vertex other) {
    return Integer.compare(minDist, other.minDist);
  }
}

public class IslandFerries {
  public static int INF = 1000000000;
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("IslandFerriesIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int numIslands = Integer.parseInt(data[0]);
      int numFerries = Integer.parseInt(data[1]);
      int destIsland = Integer.parseInt(br.readLine());
      Ferry[] ferries = new Ferry[numFerries];
      for (int i = 0; i < numFerries; i++) {
        data = br.readLine().split(" ");
        ferries[i] = new Ferry();
        ferries[i].startIsland = Integer.parseInt(data[0]);
        ferries[i].endIsland = Integer.parseInt(data[1]);
        ferries[i].ferryCost = Integer.parseInt(data[2]);
      }
      System.out.println(minTotalCost(numIslands, numFerries, destIsland, ferries));
    }
    br.close();
  }

  public static int minTotalCost(int numIslands, int numFerries, int destIsland, Ferry[] ferries) {
    int[] minDists = new int[numIslands];
    ArrayList< ArrayList<Integer> > edges = new ArrayList< ArrayList<Integer> >();
    ArrayList< PriorityQueue<Integer> > edgeWeights = new ArrayList< PriorityQueue<Integer> >();
    for (int i = 0; i < numIslands; i++) {
      edgeWeights.add(new PriorityQueue<Integer>(1, Collections.reverseOrder()));
      minDists[i] = INF;
      edges.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < numFerries; i++) {
      edgeWeights.get(ferries[i].startIsland - 1).add(ferries[i].ferryCost);
      edges.get(ferries[i].endIsland - 1).add(ferries[i].startIsland - 1);
    }
    PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
    pq.add(new Vertex(destIsland - 1, 0));
    minDists[destIsland - 1] = 0;
    for (int i = 0; i < numIslands; i++) {
      if (i != destIsland - 1) {
        pq.add(new Vertex(i, INF));
      }
    }
    while (!pq.isEmpty()) {
      Vertex v = pq.poll();
      if (minDists[v.id] != v.minDist) {
        continue;
      }
      if (v.id == 0) {
        return v.minDist;
      }
      for (int x : edges.get(v.id)) {
        if (minDists[x] == -1) {
          continue;
        }
        int w = edgeWeights.get(x).poll();
        if (v.minDist + w < minDists[x]) {
          pq.add(new Vertex(x, v.minDist + w));
          minDists[x] = v.minDist + w;
        }
      }
      minDists[v.id] = -1;
    }
    return -1;
  }
}
