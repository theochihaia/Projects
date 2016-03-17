import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumToZero {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            
            String [] readIn = line.split(",",0);
            int[] numbers = new int[readIn.length];
            for(int i = 0; i<numbers.length;i++)
            	numbers[i] = Integer.parseInt(readIn[i]);
            
            int countSumZero = 0;
            	
            for(int a = 0; a < numbers.length; a++){
            	for(int b = a + 1; b < numbers.length; b++)
            		for(int c = b + 1; c < numbers.length; c++)
            			for(int d = c + 1; d < numbers.length; d++)
            				if(numbers[a] + numbers[b] + numbers[c] + numbers[d] == 0)
            					countSumZero++;
            }
            
            System.out.println(countSumZero);
            
            
        }
    }
}
