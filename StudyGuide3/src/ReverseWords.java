import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class ReverseWords {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int ix = 0;
            Stack<String> list = new Stack<String>();
            
            while(ix < line.length()){
	            try{
	            	int divider = line.indexOf(' ',ix);
	            	list.push(line.substring(ix, divider));
	            	ix = divider + 1;
	            }catch (Exception e){
	            	list.push(line.substring(ix, line.length()));
	            	ix = line.length();
	            }
            }
            
            
           StringBuilder output = new StringBuilder();
            while (!list.empty()){
            	output.append(list.pop() + " ");
            }
            
            System.out.println(output.toString().trim());

        }
    }
}
