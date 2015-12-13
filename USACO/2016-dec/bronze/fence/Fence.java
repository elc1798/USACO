import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

class Interval {
    public int start;
    public int end;

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }

    public boolean intersects(Interval i) {
        if (i.start <= this.end && i.start >= this.start) return true;
        if (this.start <= i.end && this.start >= i.start) return true;
        return false;
    }
}

public class Fence {

    private static int min = 100;
    private static int max = 0;
    private static int painted = 0;

    private static String INPUT = "paint.in";
    private static String OUTPUT = "paint.out";
    private static Scanner fin = null;
    private static PrintWriter fout = null;
    private static String line = "";

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        line = fin.nextLine();
        String[] nums = line.split(" ");
        min = Integer.parseInt(nums[0]);
        max = Integer.parseInt(nums[1]);
        Interval a = new Interval(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));

        line = fin.nextLine();
        nums = line.split(" ");
        Interval b = new Interval(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        if (a.intersects(b)) {
            if (Integer.parseInt(nums[0]) < min) min = Integer.parseInt(nums[0]);
            if (Integer.parseInt(nums[1]) > max) max = Integer.parseInt(nums[1]);
            painted = max - min;
        } else {
            painted = (a.end - a.start) + (b.end - b.start);
        }
        fin = null;
    }

    public static void outFile() throws IOException {
        fout = new PrintWriter(new File(OUTPUT));
        String outstream = "" + painted;
        fout.println(outstream);
        fout.close();
        fout = null;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        outFile();
    }
}
