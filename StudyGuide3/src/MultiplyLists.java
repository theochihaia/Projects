
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class MultiplyLists {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            
            int divider = line.indexOf("|");           
            String txt1 = line.substring(0,divider).trim();
            String txt2 = line.substring(divider+1,line.length()).trim();

            
            String[] s1 = txt1.split(" ");
            String[] s2 = txt2.split(" ");
            for(int i = 0; i < s1.length; i++)
            	System.out.print( (Integer.parseInt(s1[i]) * Integer.parseInt(s2[i])) + " ");
            
            System.out.print("\n");

        }
    }
}