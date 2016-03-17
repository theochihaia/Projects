import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DoubleSquares {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            int num = Integer.parseInt(line);
            int count = 0;
            
            
            for(int x = 0; x < num; x++){
            	for( int y = x; y < num; y++){
            		if( x == Math.sqrt(num - Math.pow(y, 2)))
            			count++;
            	}
            }
            
        
            System.out.println(count);
            
            
        }
    }
}
