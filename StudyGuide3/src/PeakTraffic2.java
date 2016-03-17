
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;
public class PeakTraffic2 {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        // HashMap<String,HashMap<String,Boolean>> matrix = new  HashMap<String,HashMap<String,Boolean>>();
        
        // HashMap<String,Boolean> list_Start = new HashMap<String,Boolean>();
        // HashMap<String,Boolean> list_End = new HashMap<String,Boolean>();
        
        HashMap<String,Boolean> edges = new HashMap<String,Boolean>();
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            // Initialize
            Scanner scn = new Scanner(line);
            scn.useDelimiter("	");
            
            scn.next(); // String Date
            String nodeStart = scn.next().trim();
            String nodeEnd = scn.next().trim();
            
            
            // Pre-Process
            String key = (nodeStart.compareTo(nodeEnd) < 0) ? nodeStart + "|" + nodeEnd : nodeEnd + "|" + nodeStart;
            if(edges.containsKey(key)){
            	edges.remove(key);
            	edges.put(key, true);
            }else{
            	edges.put(key, false);
            }
            
            
            
        }
        
        // Analyze Edges
        ArrayList<TreeSet<String>> list = new ArrayList<>();
        for(Entry<String, Boolean> s : edges.entrySet()){
    		int divider = s.getKey().indexOf('|');
    		String startNode = s.getKey().substring(0, divider);
    		String endNode = s.getKey().substring(divider + 1, s.getKey().length());
    		
    		
    		if(s.getValue()){
    			Boolean addSet = true;
    			for(TreeSet<String> set : list){
    				if(set.contains(startNode) || set.contains(endNode)){
    					set.add(startNode);
    					set.add(endNode);
    					addSet = false;
    					break;
    				}
    			}
    			
    			if(addSet){
    				TreeSet<String> q0 = new TreeSet<String>();
    				q0.add(startNode);
    				q0.add(endNode);
    				list.add(q0);
    			}

    		}else{
    			TreeSet<String> q1 = new TreeSet<String>();
    			TreeSet<String> q2 = new TreeSet<String>();
    			q1.add(startNode);
    			q2.add(endNode);
    			// list.add(q1);
    			// list.add(q2);
    		}

        }
        
        
        // Ouput
       TreeSet<String> orderedOuput = new TreeSet<String>();
       for(TreeSet<String> group : list){
    	   if (group.size() >= 3){
    		   Iterator it = group.iterator();
        	   StringBuilder output = new StringBuilder();
        	   while(it.hasNext()){
        		   output.append(it.next() + ", ");
        	   }
        	   orderedOuput.add(output.substring(0,output.length()-2));
    	   }
       }
       
       Iterator<String> it = orderedOuput.iterator();
       while (it.hasNext()){
    	   System.out.println(it.next());
       }
        
    }
        
        
}
