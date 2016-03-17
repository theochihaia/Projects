import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextDollar {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        String[] singleDigits = {
        		"Zero"
        		,"One"
        		,"Two"
        		,"Three"
        		,"Four"
        		,"Five"
        		,"Six"
        		,"Seven"
        		,"Eight"
        		,"Nine"
        		,"Ten"
        		,"Eleven"
        		,"Twelve"
        		,"Thirteen"
        		,"Fourteen"
        		,"Fifteen"
        		,"Sixteen"
        		,"Seventeen"
        		,"Eightteen"
        		,"Nineteen"
        };
        
        String[] tens = {
        		"Ten"
        		,"Twenty"
        		,"Thrity"
        		,"Fourty"
        		,"Fifty"
        		,"Sixty"
        		,"Seventy"
        		,"Eighty"
        		,"Ninety"
        };
        
        String[] scale = {
        		"Hundred"
        		,"Thousand"
        		,"Hundred thousand"
        		,"Million"
        		,"Billion"
        		,"Trillion"
        		,"Quadrillion"
        		,"Quintillion"
        };
          
        while ((line = buffer.readLine()) != null) {
        	StringBuilder output = new StringBuilder();
            line = line.trim();

            for(int i = 0; i < line.length(); i ++){
            	
            	int num = line.charAt(i);
            	int ix = line.length() - i;
            	
            	if ( ix == 1){
            		
            	}
            	
            	// scale
           /* 	if (ix >= 3){
            		output.append(singleDigits[num] + scale[ix-2]);
            	}
            	
            */	
            	
            	
            }
            
            
 /*           for(int i = line.length() - 1; i>=0 ; i--){
            	// get scale
            	// int lookupIX = cIX + 1;
            	int num = 0;
            	if (i > 0)
            		num =  Integer.parseInt(line.substring(i-1,1));
            	else
            		num = Integer.parseInt(line.charAt(line.length()-1) + "");
            		
            	if ( i >= 2 ){
            		output.append(singleDigits[num] + scale[i-2]);
            	}
            	else if (i == 1 && num != 0){
            		output.append(tens[num-1]);
            	}
            	else if (i == 0 && num != 0){
            		output.append(singleDigits[num]);
            	}
            }
*/
            System.out.println(output + "Dollars");
        }
        
        
    }
}
