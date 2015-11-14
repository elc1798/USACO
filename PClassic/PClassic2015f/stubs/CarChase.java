import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CarChase {
 
    public static void main(String[] args) throws IOException{
    // Before submitting, make sure the main method hasn't been changed!
        String plate = "";
         BufferedReader br = new BufferedReader(new FileReader(
                    "CarChaseIN.txt"));
            while (br.ready()) {
               plate = br.readLine();
            }
            System.out.println(validPlate(plate));  
             
            br.close();
    }

    // Fill out the body of this method
    public static int validPlate(String license){
        return 0;
    }
}
