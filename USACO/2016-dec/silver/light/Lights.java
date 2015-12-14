import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

class Room {
    public int x;
    public int y;
    public boolean lit = false;
    public boolean seen = false;
    public ArrayList<int[]> switches = new ArrayList<int[]>();

    public Room(String[] line) {
        x = Integer.parseInt(line[0]) - 1;
        y = Integer.parseInt(line[1]) - 1;
        switches.add(new int[]{Integer.parseInt(line[2]) - 1, Integer.parseInt(line[3]) - 1});
    }

    public Room(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

public class Lights {

    private static String INPUT = "lightson.in";
    private static String OUTPUT = "lightson.out";
    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String[] line;

    private static Room[][] rooms;

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        line = fin.nextLine().split(" ");
        rooms = new Room[Integer.parseInt(line[0])][Integer.parseInt(line[0])];
        for (int i = 0; i < Integer.parseInt(line[1]); i++) {
            line = fin.nextLine().split(" ");
            if (rooms[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] == null) {
                rooms[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = new Room(line);
            } else {
                rooms[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1].switches.add(new int[]{Integer.parseInt(line[2]) - 1, Integer.parseInt(line[3]) - 1});
            }
        }
        fin = null;

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if (rooms[i][j] == null) {
                    rooms[i][j] = new Room(i,j);
                }
            }
        }
    }

    public static void outFile() throws IOException {
        fout = new PrintWriter(new File(OUTPUT));
        String outstream = getAns();
        fout.println(outstream);
        fout.close();
        fout = null;
    }

    public static void bfs(Room r) {
        LinkedList<Room> q = new LinkedList<Room>();
        q.addLast(r);
        while (q.size() > 0) {
            Room current = q.remove();
            current.seen = true;
            // Toggle the lights current contains:
            for (int[] coor : current.switches) {
                System.out.printf("Room %d,%d lighting up Room %d,%d\n", current.x, current.y, coor[0], coor[1]);
                rooms[coor[0]][coor[1]].lit = true;
            }
            for (int i = 0; i < rooms.length && rooms[current.x][current.y].switches.size() > 0; i++) {
                for (int j = 0; j < rooms.length; j++) {
                    rooms[i][j].seen = false;
                }
            }
            rooms[current.x][current.y].switches.clear();
            // Add connecting lit rooms
            ArrayList<Room> connecting = new ArrayList<Room>();
            if (current.x + 1 < rooms.length) connecting.add(rooms[current.x + 1][current.y]);
            if (current.x - 1 >= 0) connecting.add(rooms[current.x - 1][current.y]);
            if (current.y + 1 < rooms.length) connecting.add(rooms[current.x][current.y + 1]);
            if (current.y - 1 >= 0) connecting.add(rooms[current.x][current.y - 1]);
            for (Room rm : connecting) {
                if (rm.lit && !rm.seen) {
                    q.addLast(rm);
                } else {
                    System.out.println("Adding failed");
                }
            }
        }
    }

    public static String getAns() {
        rooms[0][0].lit = true;
        bfs(rooms[0][0]);
        int retval = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                retval += (rooms[i][j].lit) ? 1 : 0;
            }
        }
        return "" + retval;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }
}
