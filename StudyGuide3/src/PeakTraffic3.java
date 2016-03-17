
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;
public class PeakTraffic3 {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        HashMap<String, TreeSet<String>> dictionary = new HashMap<String,TreeSet<String>>();
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            

            
            // Initialize
            Scanner scn = new Scanner(line);
            scn.useDelimiter("	");
            
            scn.next(); // String Date
            String nodeStart = scn.next().trim();
            String nodeEnd = scn.next().trim();
            
            if(!dictionary.containsKey(nodeStart)){
            	TreeSet<String> tmpEnd = new TreeSet<String>();
            	tmpEnd.add(nodeEnd);
            	dictionary.put(nodeStart,tmpEnd);	
            }else{
            	dictionary.get(nodeStart).add(nodeEnd);
            }
            	
        }
        
        
        // Process Groups
        TreeSet<String> senderList = (TreeSet<String>) dictionary.keySet();
        
        
        // for every key, create group and add receive nodes that also sent it a message
        for(String key : senderList){
        	ArrayList<String> set = getDoublyLinkedSet(key,dictionary.get(key));
        }
            
    }

	private static ArrayList<String> getDoublyLinkedSet(String key,
			ArrayList<String> treeSet) {
		
		return treeSet.addAll(0, getDoublyLinkedSet(treeSet.remove(0));
	}      
            
            
            
        
        
}
