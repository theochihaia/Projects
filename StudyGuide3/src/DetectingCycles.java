import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class DetectingCycles {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            
            Scanner s = new Scanner(line);
            s.useDelimiter(" ");
            
            int input[] = new int[line.length()/2 + 1];
            int ix = 0;
            
            Scanner scn = new Scanner(line);
            
            while(scn.hasNext()){
            	input[ix] = scn.nextInt();
            	ix++;
            }
            int cnt = 0;
            int repeatLength = 0;
            int startindex = 0;
            for(int tortoise = 0; tortoise < ix; tortoise++){
            	for(int spacing = 1; spacing< ix/2 ; spacing++){
            		int rabbit = tortoise + spacing;
            		int index = 0;
            		while(rabbit+index < ix){
	        			if(input[tortoise+index] == input[rabbit+index]){
	        				cnt++;
	        				
	        				if(cnt>=1){
		        				repeatLength = spacing;
		        				startindex = tortoise + (index-0);
		        				break;
	        				}
	        					
	        			}
            			index++;
            		}
            		if(cnt>=1){break;}
            	}
            	if(cnt>=1){break;}
            }
            
            StringBuilder output = new StringBuilder();
            for(int y = startindex; y<startindex+repeatLength; y++){
            	output.append(input[y] + " ");
            }
            
            System.out.println(output.toString().trim());
          
            
        }
    }
}