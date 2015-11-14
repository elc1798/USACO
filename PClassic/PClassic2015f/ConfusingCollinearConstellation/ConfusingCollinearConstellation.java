import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class slope {
    public int dx;
    public int dy;
    public slope(int x1, int y1, int x2, int y2) {
        dx = x2 - x1;
        dy = y2 - y1;
    }
}

class customCoor {
    public int x;
    public int y;
    public int xo;
    public int yo;
    public slope m;
    public customCoor(int x1, int y1, int x2, int y2) {
        x = x1;
        y = y1;
        xo = x2;
        yo = y2;
        m = new slope(x1,y1,x2,y2);
    }
    public boolean onLine(int x1, int y1) {
        return (y1 - y) * m.dx == (x1 - x) * m.dy;
    }
}

public class ConfusingCollinearConstellation {
    public static void main(String[] args) throws IOException {
    	// Before submitting, make sure the main method hasn't been changed!
        BufferedReader br = new BufferedReader(new FileReader(
                "ConstellationIN.txt"));
        while (br.ready()) {
            String[] data = br.readLine().split(" ");
            int[] pts;
            pts = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                pts[i] = Integer.parseInt(data[i]);
            }
            System.out.println(hasCollinear(pts));
        }
        br.close();
    }

    // Fill out the body of this method
    private static boolean hasCollinear(int[] pts) {
        if (pts.length > 500) return false;
        int[] pt1 = {pts[0], pts[1]};
        int[] pt2 = {pts[2], pts[3]};
        ArrayList<customCoor> lines = new ArrayList<customCoor>();
        lines.add(new customCoor(pt1[0], pt1[1], pt2[0], pt2[1]));
        for (int i = 4; i < pts.length; i += 2) {
            ArrayList<customCoor> newLines = new ArrayList<customCoor>();
            int[] ptn = {pts[i], pts[i + 1]};
            for (customCoor line : lines) {
                if (line.onLine(ptn[0], ptn[1])) {
                    return true;
                } else {
                    newLines.add(new customCoor(line.x, line.y, ptn[0], ptn[1]));
                    newLines.add(new customCoor(line.xo, line.yo, ptn[0], ptn[1]));
                }
            }
            for (customCoor line : newLines) {
                lines.add(line);
            }
        }
        return false;
    }
 
}
