import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GuessTheNumber {
    final static String LOWER = "Lower";
    final static String HIGHER = "Higher";
    
    public static void main (String[] args) throws IOException {    
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] values = line.split(" ");
            
            System.out.println(guess(values));
            
        }
    }
    
    public static int guess(String[] responses){
    	int num = Integer.parseInt(responses[0])/2;
        int guess_prev = 0;
        for(int i = 1; i < responses.length; i++){
        	if(responses[i].equals(LOWER)){
        		int tmp = num;
        		num = num - (num - guess_prev)/2;
        		guess_prev = tmp;
        	}else if(responses[i].equals(HIGHER)){
        		int tmp = num;
        		num = num + (num - guess_prev)/2;
        		guess_prev = tmp;
        	}
        }
        

    	return num;
    }
    

}

