import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FindAWriter {
	private static BufferedReader buffer;

	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            int ix_encoding = line.indexOf('|');
            StringBuilder str = new StringBuilder();
            String encoded_string = line.substring(0, ix_encoding);
            String key_encoding = line.substring(ix_encoding + 2, line.length());
            String[] keys = key_encoding.split(" ");
           for(String key:keys){
            	str.append(encoded_string.charAt(Integer.parseInt(key)-1));
            }
            System.out.println(str.toString());
        }
    }

}
