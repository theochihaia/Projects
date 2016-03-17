
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class ASCII_Decryption2 {
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
                      
            char encodedChar = knownLastChar;
           // for each group of 5 letters
            
            HashMap<Character,Integer> candidates = new HashMap<Character,Integer>();
            
            for(char c : encMessage){
            	if(candidates.containsKey(c)){
            		candidates.put(c, candidates.get(c) + 1 );
            	}else{
            		candidates.put(c, 1 );
            	}
            		
            }
            // System.out.println(candidates);
            
            Iterator it = candidates.entrySet().iterator();
            char maxChar = 0;
            int maxCount = -1;
            while(it.hasNext()){
            	Map.Entry<Character, Integer> var = (Map.Entry<Character, Integer>) it.next();
            	
            	if(var.getValue() > maxCount){
            		maxCount = var.getValue();
            		maxChar = var.getKey();
            	}
            }
            
            int decoder = findDistance(maxChar,knownLastChar);
            for(int i = 0; i < encMessage.length; i++){
            	encMessage[i] = (char) ( (encMessage[i] + decoder) );
            }
            System.out.println(encMessage);
	}
        
}    
    
    static void initParameters(String input){
        int ixCntKnownWord = input.indexOf('|');
        knownWordLength = Integer.parseInt(input.substring(0, ixCntKnownWord).trim());
        int ixLastChar = input.indexOf('|',ixCntKnownWord+1);
        knownLastChar = input.substring(ixCntKnownWord + 1,ixLastChar).trim().charAt(0);
        
        // overload
        knownLastChar = ' ';
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