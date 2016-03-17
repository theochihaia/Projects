import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Transform {
	public static void main (String [] args){
		String[] dic = {"hey","this","is","some","test","how","hot","boy","hoy"};
		Set<String> dictionary = new HashSet<String>(Arrays.asList(dic));
		String start = "hey";
		String end = "hot";
		
		
		
		
		
		System.out.println("Start: " + start);
		
		System.out.println("Transform: ");
		for(String s : transform(start,end,dictionary)){
			System.out.println("-> " + s);
		}
		
		System.out.println("End: " + end);
	}
	
	private static LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary){
		
		Queue<String> actionQueue = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String,String>();
		
		actionQueue.add(startWord);
		visitedSet.add(startWord);
		
		while (!actionQueue.isEmpty()){
			String w = actionQueue.poll();
			
			for(String v: getOneEditWords(w)){
				if(v.equals(stopWord)){
					
					LinkedList<String> list = new LinkedList<String>();
					list.add(v);
					while (w != null){
						list.add(0,w);
						w = backtrackMap.get(w);
					}
					return list;
				}
				if(dictionary.contains(v)){
					if(!visitedSet.contains(v)){
						actionQueue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v,w);
					}
				}
			}
		}
		
		return null;
		
	}

	private static Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<String>();
		for(int i = 0; i < word.length(); i++){
			char[] wordArray = word.toCharArray();
			for(char c = 'a'; c <= 'z'; c++){
				if(c != word.charAt(i)){
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}
}
