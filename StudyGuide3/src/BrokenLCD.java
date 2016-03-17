
import java.io.*;


/* 
 *	Question: How to handle decimal?
 */


public class BrokenLCD implements Runnable{
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        // Initialize
        byte[] lcd = new byte[12];
        boolean[] decimal = new boolean[12];
        byte[] dict = {
        		(byte) 0b1111110
        		,(byte) 0b0110000
        		,(byte) 0b1101101
        		,(byte) 0b1111001
        		,(byte) 0b0110011
        		,(byte) 0b1011011
        		,(byte) 0b1011111
        		,(byte) 0b1110000
        		,(byte) 0b1111111
        		,(byte) 0b1111011
        };
        
        boolean[] seqValidity= new boolean[101];
        short val_ix = 0;
        
        // Parse each scenario
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int div_ix = line.indexOf(';');
            String num = line.substring(div_ix + 1, line.length()-1);
            String[] lcdStatus = line.substring(0, div_ix).split(" ");
          
           // Process Viability
            for (int i = 0; i < lcdStatus.length; i++){
            	lcd[i] = Byte.parseByte(lcdStatus[i].substring(0, 7),2);
            	decimal[i] = lcdStatus[i].substring(7).compareTo("1") == 0;
            }
            
            // iterate through each possible lcd position until length of number
            for(int i = 0; i<12-num.length(); i++){
            	boolean valid = true;
            	boolean isInt = true;
            	// for each number in num, check if each node is active
            	int ix = 0;
            	for(char c : num.toCharArray()){
            		
            		if(c == '.'){
            			valid &= decimal[ix-1 + i];
            			isInt = false;
            		}
            		else{
            			byte digit = dict[c-'0'];
            			byte scrn = lcd[ix + i];
            			valid &= ( scrn & digit) == digit;
            			ix++;
            		}

            		if(!valid)
            			break;
            		            		
            	}
            	if(valid){
            		// if validity hasn't failed, we found a working solution
            		if(isInt){
            			seqValidity[val_ix] = valid && decimal[i+num.length()];
            		} else{
            			seqValidity[val_ix] = valid;
            		}
            		
            		break;
            	}
            		
            }
            
            // prepare for the next word
            System.out.println( (seqValidity[val_ix]) ? "1" : "0");
            val_ix ++;
           
        }
        
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

