import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DoubleSquares2 {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            int num = Integer.parseInt(line);
            int p = (int) Math.sqrt((float) num/2.0);
            int count = 0;
            
            
            for(int x = 0; x < p; x++){
            	double j = Math.sqrt((double) num - x*x);
            		if( j - (int) j == 0.0)
            			count++;
            	
            }
            
        
            System.out.println(count);
            
            
        }
    }
}
