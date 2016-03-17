
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
public class PeakTraffic4 {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        HashMap<Node, TreeSet<Node>> dictionary = new HashMap<Node,TreeSet<Node>>();
        TreeSet<Group> groups = new TreeSet<Group>();
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            

            
            // Initialize
            Scanner scn = new Scanner(line);
            scn.useDelimiter("	");
            
            scn.next(); // String Date
            Node nodeStart = new Node(scn.next().trim());
            Node nodeEnd = new Node(scn.next().trim());
            
            
            // System.out.println("Start: " + nodeStart + "End: " + nodeEnd);
            
            if(dictionary.containsKey(nodeStart)){
            	dictionary.get(nodeStart).add(nodeEnd);
            } else {
            	dictionary.put(nodeStart, new TreeSet<Node>());
            	dictionary.get(nodeStart).add(nodeEnd);
            }
 
            
        }
        
        
        // Get Groups - A group is a set of nodes where all of them talk to each other
        // groups.add(new TreeSet<Node>());
        
        // Iterate through nodes
        Iterator it = dictionary.keySet().iterator();
        while (it.hasNext()){
        	Node node = (Node) it.next();
        	// System.out.println(node);
        	TreeSet<Node> list = new TreeSet<Node>();
        	node.isVisited = true;
        	list.add(node);
        	
        	TreeSet<Node> tmp = getCluster(node, dictionary,list);
        	if(tmp.size() >= 3){
        		// Collections.sort(tmp);
        		groups.add(new Group(tmp));
        	}
        	// System.out.println(tmp);
        	
        	
        }
        
        
        StringBuilder str = new StringBuilder();
        // groups.sort(new Comparator());
        // Collections.sort((T<Node>) groups);
		for(Group grp : groups){
			String s = "";
			for(Node n : grp.list){
				s += n + ", ";
			}
			str.append(s.toString().substring(0, s.length()-2) + "\n");
		}
		System.out.println(str.toString().substring(0, str.length()-1));


    }
    
    
    
    static TreeSet<Node> getCluster(Node node_next, HashMap<Node, TreeSet<Node>> dict, TreeSet<Node> list){
    	
    	
    	
    	// Get neighbors
    	// TreeSet<Node> neighbors = dict.get(node_next);
    	
    	// check if neighbor contains a
        Iterator it = dict.keySet().iterator();
        while (it.hasNext()){
        	Node n = (Node) it.next();
        	if(dict.get(n).contains(node_next) ){// && !n.isVisited){
        		// we have a 2 directional connection
        		list.add(n);
        		n.isVisited = true;
        	}
        }
        

    	return list;
    }
    
        
}

/*
class Group implements Comparable{

	TreeSet<Node> list;
	Group(TreeSet<Node> list){
		this.list = list;
	}
	
	@Override
	public int compareTo(Object o) {
		Node n1 = list.first();
		Node n2 = ((Group) o).list.first();
		return n1.compareTo(n2);
	}
	
	
}
    */

class Node implements Comparable{
	
	boolean isVisited;
	String value;
	Node(String s){
		this.value = s;
		
	}
	@Override
	public int compareTo(Object elem) {
		// TODO Auto-generated method stub
		Node n = (Node) elem;
		return this.value.compareTo(n.value);
	}
	
	public String toString(){
		// return "Value: " + value + " isVisited: " + isVisited;
		return value;
	}
	
}


