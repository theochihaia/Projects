
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RemoveCharacters {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            
            int divider = line.indexOf(',');
            StringBuilder output = new StringBuilder();
            String filter = line.substring(divider + 1, line.length()).trim();
            
            
            for(int i = 0; i<divider; i++){
            	boolean isValid = true;
            	for (int f = 0; f<filter.length(); f++){
            		if(filter.charAt(f) == line.charAt(i)){
            			isValid = false;
            			break;
            		}
            	}
            	if(isValid)
            		output.append(line.charAt(i));
            }
            
            System.out.println(output.toString().trim());
            
            
        }
    }
}
