import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Modulous {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            // String[] numbers = line.split(",");
            
            int mid = line.indexOf(',');
            int num = Integer.parseInt(line.substring(0, mid));
            int modulo = Integer.parseInt(line.substring(mid+1));
            int quotient = num / modulo;
            
            System.out.println( (quotient > 0) ? num - (quotient * modulo) : num);
            
        }
    }
}
