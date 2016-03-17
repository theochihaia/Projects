
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class ASCII_Decryption {
    private static int knownWordLength;
    private static char knownLastChar;
    private static String message;
    
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            initParameters(line);
            
            String [] tmp = message.split(" ");
            char[] encMessage = new char[tmp.length];
            
            for(int i = 0; i < tmp.length; i++){
            	encMessage[i] = (char) Integer.parseInt(tmp[i]);
            }
            
 // (|pm(           
            char encodedChar = knownLastChar;
           // for each group of 5 letters
            
            HashMap<String,Integer> candidates = new HashMap<String,Integer>();
            
            for(int x = 0; x<encMessage.length - 2 * knownWordLength; x++){
            	// if word_1 last_letter == word_2 last_letter, assume last letter is 's' and find shift amount
            	boolean continuous = false;
            	int cntContinuous = 0;
            	
	           	for(int y = x + knownWordLength; y < encMessage.length - knownWordLength ; y++){
	            		StringBuilder a = new StringBuilder();
	            		StringBuilder b = new StringBuilder();
	
	    				for(int len1 = x; len1 < x + knownWordLength; len1++){
	    					a.append(encMessage[len1]);
	    				}
	    				for(int len2 = y; len2 < y + knownWordLength; len2++){
	    					b.append(encMessage[len2]);
	    				}
	    				
	    				// check if words match and if the word that matches is only of size knownWordLength
	    				if(a.toString().equals(b.toString()) 
	    						&& encMessage[x-1] != encMessage[y-1]
	    						&& encMessage[x+knownWordLength-1] != encMessage[y+knownWordLength-1]
	    						){
	    					
	    					encodedChar = a.toString().charAt(a.length()-1);
	    					
	    					candidates.put(a.toString(), 1);
	    					
		    			/*	System.out.println("Comparing: ");
		    				System.out.println(a);
		    				System.out.println(b);
		    				System.out.println(a.equals(b));  */
	    					
	    					//  break;
	    				}
	    				
	    		/*		System.out.println("Comparing: ");
	    				System.out.println(a);
	    				System.out.println(b);
	    				System.out.println(a.equals(b)); */
    					
	            	}
            	
            	}
            
            int decoder = findDistance(encodedChar,knownLastChar);
            
            
            Set<String> it = candidates.keySet();
            System.out.println("Candidates:");
            for(String s: it){
            	System.out.println("    " + s);
            }
            
            System.out.println("Decoder Shift: " + decoder);
            System.out.println("Encoded Char: " + encodedChar);
            System.out.println("Decoded Char: " + (char) (encodedChar + decoder));
            
            
            for(int i = 0; i < encMessage.length; i++){
            	encMessage[i] = (char) ( (encMessage[i] - decoder) % 254 );
            }
            
            System.out.println(encMessage);
            
        }       
	}
        
        
    
    static void initParameters(String input){
        int ixCntKnownWord = input.indexOf('|');
        knownWordLength = Integer.parseInt(input.substring(0, ixCntKnownWord).trim());
        int ixLastChar = input.indexOf('|',ixCntKnownWord+1);
        knownLastChar = input.substring(ixCntKnownWord + 1,ixLastChar).trim().charAt(0);
        message = input.substring(ixLastChar + 1).trim();
    }
    
    // find distance ('s',char[n])
    static int findDistance(char x, char y){
    	// ASCII is 0 -> 127
        for(int i = 0; i < 127; i++){
        	// need to find an instance where 5 character spread has an s at the end
        }
        return y-x;
    }
    
    
    
    static String decode(String s, int shift){
    	return null;
    }
    
    
 
    
    
}