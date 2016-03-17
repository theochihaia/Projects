import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class MinimumCoins {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            
            int total = Integer.parseInt(line);
            System.out.println((total / 5) + ( ( total % 5 ) / 3 ) + ( ( total % 5 ) % 3 )); 
            
            
 /*           int coins[] = {5,3,1};
            int total = Integer.parseInt(line);
            int count = 0;
            int ix = 0;
            
            while(ix < 4){
            	if(total % coins[ix] == 0){
            		count = count + (total / coins[ix]);
            		ix = 4;
            	}else{
            		int remainder = total % coins[ix];
            		count = count + (total / coins[ix]);
            		total = remainder;
            		ix ++;
            	}
            		
            }
            
         
            		System.out.println(count);
             */
        }
    }
}