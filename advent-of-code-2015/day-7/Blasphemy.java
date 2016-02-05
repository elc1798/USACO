// Omg a non trivial task omg omg like it's like an interpreter oh my gosh
import java.util.Scanner;
import java.util.Hashtable;
import java.util.LinkedList;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Blasphemy {

    private static String INPUT = "in";
    private static Scanner fin = null;
    private static String line = "";

    private static Hashtable<String, Short> vars = new Hashtable<String, Short>();
    private static LinkedList<String> commandQueue = new LinkedList<String>();

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static short[] getOps() {
        short op1;
        String sop1 = commandQueue.pollFirst();
        if (isNumeric(sop1)) {
            op1 = Short.parseShort(sop1);
        } else {
            // Look up in hashtable
            op1 = vars.get(sop1);
        }
        // Get rid of the "AND"
        commandQueue.pollFirst();
        // Get the second operand
        short op2;
        String sop2 = commandQueue.pollFirst();
        if (isNumeric(sop2)) {
            op2 = Short.parseShort(sop2);
        } else {
            // Look up in hashtable
            op2 = vars.get(sop2);
        }
        return new short[]{op1, op2};
    }

    public static void readFile() throws IOException {
        fin = new Scanner(new File(INPUT));
        while (fin.hasNext()) {
            line = fin.nextLine();
            String[] args = line.split(" ");
            // Build up a queue of commands
            for (String arg : args) {
                commandQueue.addLast(arg);
            }
            while (commandQueue.size() > 0) {
                // Check for operations
                if (commandQueue.get(1).equals("AND")) {
                    short[] ops = getOps();
                    short res = ops[0] & ops[1];
                    commandQueue.addFirst("" + res);
                } else if (commandQueue.get(1).equals("OR")) {
                    short[] ops = getOps();
                    short res = ops[0] | ops[1];
                    commandQueue.addFirst("" + res);
                } else if (commandQueue.get(1).equals("LSHIFT")) {
                    short[] ops = getOps();
                    short res = ops[0] << ops[1];
                    commandQueue.addFirst("" + res);
                } else if (commandQueue.get(1).equals("RSHIFT")) {
                    short[] ops = getOps();
                    short res = ops[0] >> ops[1];
                    commandQueue.addFirst("" + res);
                } else if (commandQueue.get(0).equals("NOT")) {
                    String sop = commandQueue.pollFirst();
                    short op;
                    if (isNumeric(sop)) {
                        op = Short.parseShort(sop);
                    } else {
                        op = vars.get(sop);
                    }
                    commandQueue.addFirst("" + (~op));
                } else if (commandQueue.get(1).equals("->")) {
                    String sop = commandQueue.pollFirst();
                    short op;
                    if (isNumeric(sop)) {
                        op = Short.parseShort(sop);
                    } else {
                        op = vars.get(sop);
                    }
                    commandQueue.pollFirst();
                    String newVar = commandQueue.pollFirst();
                    vars.put(newVar, op);
                } else if (isNumeric(commandQueue.get(0))) {
                    System.out.println("Wtf go do something else");
                } else {
                    System.out.println("Wtf? " + commandQueue.get(0));
                }
            }
        }
        fin = null;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        System.out.println("" + vars.get("a"));
    }
}
