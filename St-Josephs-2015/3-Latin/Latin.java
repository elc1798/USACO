import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Latin {

    /*
     * Pseudocode:
     *
     * Build array of all the sentences
     * Split sentences into array of words
     * Split into array of characters
     * Check to see if first element is a vowel
     * If so, add 'way' to the end (No need to check capitalization)
     * Note:
     * 'A' -> 65
     * 'a' -> 97
     * 
     * If not, add 32 to the char value (make lowercase), move to end, add "ay"
     * Then subtract 32 from new first character
     *
     */

    private static final String inputFile = "LatinIn.txt";
    private static final char[] vowels = {'A' , 'E' , 'I' , 'O' , 'U' , 'a' , 'e' , 'i' , 'o' , 'u'};
    private static String[] sentences;

    private static boolean isVowel(char c) {
        for (char v : vowels) {
            if (v == c) {
                return true;
            }
        }
        return false;
    }

    private static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        // Perform operations here
        int numSentences = Integer.parseInt(br.readLine().trim());
        sentences = new String[numSentences];
        for (int i = 0; i < numSentences; i++) {
            sentences[i] = br.readLine().trim();
        }
        br.close();
    }

    private static void solve() {
        for (String s : sentences) {
            String latin = "";
            String[] words = s.split(" ");
            for (String word : words) {
                char[] letters = word.toCharArray();
                char[] latinizer = new char[0];
                if (isVowel(letters[0])) {
                    latinizer = new char[letters.length + 3];
                    System.arraycopy(letters , 0, latinizer , 0 , letters.length);
                    latinizer[letters.length] = 'w';
                    latinizer[letters.length + 1] = 'a';
                    latinizer[letters.length + 2] = 'y';
                } else {
                    // Note that the range of the integer value of an alphabet
                    // character is between 65 and 129
                    latinizer = new char[letters.length + 2];
                    if ((int)letters[0] < 97 && (int)letters[0] >= 65) { // Uppercase
                        System.arraycopy(letters , 1 , latinizer , 0 , letters.length - 1);
                        if ((int)latinizer[0] >= 97) {
                            latinizer[0] = (char)((int)latinizer[0] - 32);
                            latinizer[letters.length - 1] = (char)((int)letters[0] + 32);
                            latinizer[letters.length] = 'a';
                            latinizer[letters.length + 1] = 'y';
                        }
                    } else {
                        System.arraycopy(letters , 1 , latinizer , 0 , letters.length - 1);
                        latinizer[letters.length - 1] = letters[0];
                        latinizer[letters.length] = 'a';
                        latinizer[letters.length + 1] = 'y';
                    }
                }
                latin += new String(latinizer) + " ";
            }
            System.out.println(latin.trim());
        }
    }

    public static void main(String[] args) throws Exception {
        readFile();
        solve();
    }
}
