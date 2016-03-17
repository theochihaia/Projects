
import java.io.*;
import java.util.Stack;
public class ColumnNames {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	line = line.trim();
        	Stack<Integer> numSlot = new Stack<Integer>();
            int num = Integer.parseInt(line);
            int cntLetters = 26;
            
            // NOTE: ASCII 65-90
            
            
            
            int radix[] = new int[10];
            
            int quotient = num;
            int ix = 0;
            while(quotient > 0){
            	int remainder = quotient % cntLetters;
            	// numSlot.add(remainder);
            	numSlot.add( (remainder == 0 ? 26 : remainder));
            	// radix[ix] = quotient % cntLetters;
            	if( quotient < cntLetters)
            		quotient = quotient / cntLetters - 1;
            	else
            		quotient = quotient / cntLetters;
            	ix ++;
            }
            
            while(!numSlot.isEmpty()){
            	// System.out.print(numSlot.pop() +",");
            	System.out.print((char) ( numSlot.pop() + 64) +",");
            }
            System.out.println();
  //          double numberLetters = (double) num / lettersAlphabet;
           
            
  //          System.out.println("Num Letters = " + numberLetters );
            
/*            
            if(numberLetters / 24 >= 1){
            	
            }else{
            	
            	for(int)
            	
            }
            
            */
            
        }
    }
}