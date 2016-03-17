
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class AgeDistribution {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            String output = "This program is for humans";
            int age = Integer.parseInt(line);
            
            if (0 <= age && age <= 2)
            	output = "Still in Mama's arms";
            else if (3 <= age && age <= 4)
            	output = "Preschool Maniac";
            else if (5 <= age && age <= 11)
            	output = "Elementary school";
            else if (12 <= age && age <= 14)
            	output = "Middle school";            	
            else if (15 <= age && age <= 18)
            	output = "High school"; 
            else if (19 <= age && age <= 22)
            	output = "College"; 
            else if (23 <= age && age <= 65)
            	output = "Working for the man"; 
            else if (66 <= age && age <= 100)
            	output = "The Golden Years"; 
            
        	System.out.println(output);
        
        }
    }
}
