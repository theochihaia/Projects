import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FizzBuzz {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            
            String arr[] = line.split(" ");
            int num_F = Integer.parseInt((arr[0]));
            int num_B = Integer.parseInt((arr[1]));
            int num_Div = Integer.parseInt((arr[2]));
            
            for(int i = 1; i <= num_Div; i++){
            	boolean div_F = i % num_F == 0;
            	boolean div_B = i % num_B == 0;
            	
            	if(div_F && div_B)
            		System.out.print("FB ");
            	else if (div_F)
            		System.out.print("F ");
            	else if (div_B)
            		System.out.print("B ");
            	else
            		System.out.print(i + " ");
            }
            System.out.println();
            
        }
    }
}
