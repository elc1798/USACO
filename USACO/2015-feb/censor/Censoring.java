import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Censoring {
    public static String message;
    public static String censoring;

    public static void readFromFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        message = br.readLine();
        censoring = br.readLine();

        br.close();
    }

    public static void process() {
        int ml = -1;
        while (ml != message.length()) {
            ml = message.length();
            /*
            for (int i = 0; i < message.length() - censoring.length(); i++) {
                if (message.substring(i , i + censoring.length()).equals(censoring)) {
                    message = message.substring(0 , i) + "A" + message.substring(i + censoring.length());
                }
            }
            */
//            message = message.replace(censoring , "ABCDEFG");
            message = message.replace(censoring , "");
        }
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("censor.out"));
        fout.println(message);
        fout.close();
        fout = null;
    }

    public static void main(String[] args) throws IOException {
        File fin = new File("censor.in");
        readFromFile(fin);
        process();
        writeout();
    }

}
