import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Lucky {

    /*
     * Pseudocode:
     *
     * Create an arraylist
     * Start with n = 1 (second number) and end at n = the game size
     * Have a static array that lists all the first 10000 odd numbers so we
     * don't have to keep recreating it (save time)
     * Loop once, copy the array into a new array with 1 less in the length
     * removing the kth element
     * Print out array[k - 1]
     *
     */

    private static final String inputFile = "LuckyIn.txt";
    private static final int START_SIZE = 10000;
    private static int[] start;
    private static int[] games;

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here
        int numGames = Integer.parseInt(br.readLine().trim());
        games = new int[numGames];
        for (int i = 0; i < numGames; i++) {
            games[i] = Integer.parseInt(br.readLine().trim());
        }
        br.close();
    }

    private static void solve() {
        setup();
        int[] currGame;
        for (int n : games) {
            currGame = new int[START_SIZE];
            System.arraycopy(start , 0 , currGame , 0 , START_SIZE);
            for (int i = 1; i < n; i++) {
                int k = currGame[i];
                for (int counter = k - 1; counter < currGame.length; counter += k) {
                    int[] tmp = new int[currGame.length - 1];
                    System.arraycopy(currGame , 0 , tmp , 0 , counter);
                    System.arraycopy(currGame , counter + 1, tmp , counter , tmp.length - counter);
                    currGame = tmp;
                    counter--;
                }
            }
            System.out.println(currGame[n - 1]);
        }
    }

    private static void setup() {
        start = new int[START_SIZE];
        for (int i = 0; i < START_SIZE; i++) {
            start[i] = 1 + 2 * i;
        }
    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
