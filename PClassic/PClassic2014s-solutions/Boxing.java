import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Boxing {
    
    //Make sure before you submit that the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BoxingIN.txt"));
        
        while (br.ready()) {
            Boxer[] boxers = new Boxer[2];
            for (int i = 0; i < 2; i++) {
                String[] fighter = br.readLine().split(" ");
                String[] strategy = br.readLine().split(" ");

                String name = fighter[0];
                double health = Integer.parseInt(fighter[1])*1.0;
                double j = Double.parseDouble(fighter[2]);
                double h = Double.parseDouble(fighter[3]);
                double u = Double.parseDouble(fighter[4]);

                boxers[i] = new Boxer(name, health, j, h, u, strategy);
            }
            System.out.println(findWinner(boxers[0], boxers[1]));
        }

        br.close();
    }
    
    //Fill out the body of this method
    public static String findWinner(Boxer b1, Boxer b2) {
        for (int i = 0; i < b1.strategy.length; i++) {
            String m1 = b1.strategy[i];
            String m2 = b2.strategy[i];

            if (m1.equals("U") && m2.equals("J")) {
                b1.health -= b2.jabStrength*1.0;
            } else if (m1.equals("J") && m2.equals("U")) {
                b2.health -= b1.jabStrength*1.0;
            } else {
                if (m1.equals("J")) {
                    b2.health -= b1.jabStrength*1.0;
                } else if (m1.equals("H")) {
                    b2.health -= b1.hookStrength*2.0;
                } else {
                    b2.health -= b1.uppercutStrength*3.0;
                }

                if (m2.equals("J")) {
                    b1.health -= b2.jabStrength*1.0;
                } else if (m2.equals("H")) {
                    b1.health -= b2.hookStrength*2.0;
                } else {
                    b1.health -= b2.uppercutStrength*3.0;
                }
            }

            if (b1.health <= 0) {
                return b2.name;
            } else if (b2.health <= 0) {
                return b1.name;
            }
        }

        if (b1.health > b2.health) {
            return b1.name;
        } else {
            return b2.name;
        }
    }

    private static class Boxer {
        public String name;
        public double health;
        public double jabStrength;
        public double hookStrength;
        public double uppercutStrength;
        public String[] strategy;

        public Boxer(String name, double health,
                     double j, double h, double u, String[] s) {
            this.name = name;
            this.health = health;
            jabStrength = j;
            hookStrength = h;
            uppercutStrength = u;
            strategy = s;
        }
    }

}
