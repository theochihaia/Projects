import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;


public class EmailValidation {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            
            boolean isEmail = true;
            
            int ix_At = line.indexOf('@');
            // whatever
            
            char[] chars = line.toCharArray();
            
            for (char c : chars) {
                if(!Character.isLetter(c)) {
                	System.out.println(Boolean.TRUE);
                }
            }

            
            
            
            
            if(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", line))
            	 System.out.println(Boolean.TRUE);
            else{
            	System.out.println(Boolean.FALSE);
            }

        }
    }
}
