
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
public class PeakTraffic5 {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        HashMap<String, TreeSet<String>> dictionary = new HashMap<String,TreeSet<String>>();
        TreeSet<Group> groups = new TreeSet<Group>();
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            

            
            // Initialize
            Scanner scn = new Scanner(line);
            scn.useDelimiter("	");
            
            scn.next(); // String Date
            String StringStart = new String(scn.next().trim());
            String StringEnd = new String(scn.next().trim());
            
            
            // System.out.println("Start: " + StringStart + "End: " + StringEnd);
            
            if(dictionary.containsKey(StringStart)){
            	dictionary.get(StringStart).add(StringEnd);
            } else {
            	dictionary.put(StringStart, new TreeSet<String>());
            	dictionary.get(StringStart).add(StringEnd);
            }
 
            
        }
        
        
        // Get Groups - A group is a set of Strings where all of them talk to each other
        // groups.add(new TreeSet<String>());
        
        // Iterate through Strings
        Iterator it = dictionary.keySet().iterator();
        while (it.hasNext()){
        	String node = (String) it.next();
        	// System.out.println(String);
        	TreeSet<String> list = new TreeSet<String>();
        	list.add(node);
        	
        	TreeSet<String> tmp = getCluster(node, dictionary,list);
        	if(tmp.size() >= 3){
        		// Collections.sort(tmp);
        		groups.add(new Group(tmp));
        	}
        	// System.out.println(tmp);
        	
        	
        }
        
        // remove subclusters
        Iterator<Group> gIt_1 = new TreeSet<Group>(groups).iterator();
        Iterator<Group> gIt_2 = new TreeSet<Group>(groups).iterator();

        
/*        while (gIt_1.hasNext()){
        	Group g_tmp = gIt_1.next();
        	if (g_tmp.list.size() > groups.
        	
        } */
      
        
        StringBuilder str = new StringBuilder();
        // groups.sort(new Comparator());
        // Collections.sort((T<String>) groups);
		for(Group grp : groups){
			String s = "";
			for(String n : grp.list){
				s += n + ", ";
			}
			str.append(s.toString().substring(0, s.length()-2) + "\n");
		}
		System.out.println(str.toString().substring(0, str.length()-1));
		

    }
    
    
    
    static TreeSet<String> getCluster(String String_next, HashMap<String, TreeSet<String>> dict, TreeSet<String> list){
    	
    	
    	
    	// Get neighbors
    	TreeSet<String> neighbors = dict.get(String_next);
    	
    	// check if neighbor contains a
        Iterator it = neighbors.iterator();
        while (it.hasNext()){
        	String n = (String) it.next();
        	TreeSet<String> n_list = dict.get(n);
        	if(n_list != null){
	        	if(n_list.contains(String_next) ){// && !n.isVisited){
	        		// we have a 2 directional connection
	        		list.add(n);
	        	}
        	}
        }
        

    	return list;
    }
    
        
}

class Group implements Comparable{

	TreeSet<String> list;
	Group(TreeSet<String> list){
		this.list = list;
	}
	
	@Override
	public int compareTo(Object o) {
		String n1 = list.first();
		String n2 = ((Group) o).list.first();
		return n1.compareTo(n2);
	}
	
	boolean isSubCluster(TreeSet<String> s2){
		TreeSet<String> tmp = new TreeSet<String>(list);
		tmp.addAll(s2);
		return tmp.equals(list);
	}
	
	
}
    
/*
class String implements Comparable{
	
	boolean isVisited;
	String value;
	String(String s){
		this.value = s;
		
	}
	@Override
	public int compareTo(Object elem) {
		// TODO Auto-generated method stub
		String n = (String) elem;
		return this.value.compareTo(n.value);
	}
	
	public String toString(){
		// return "Value: " + value + " isVisited: " + isVisited;
		return value;
	}
	
} */


