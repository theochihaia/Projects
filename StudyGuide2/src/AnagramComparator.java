import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;


public class AnagramComparator implements Comparator<String>{

	public String sortChars(String s){
		
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	
	public int compare(String s1, String s2) {
		
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	
	public void sort(String[] array){
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		
		/* Group words by anagram */
		for(String s : array){
			String key = sortChars(s);
			if(!hash.containsKey(key)){
				hash.put(key,  new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		int index = 0;
		for(String key: hash.keySet()){
			LinkedList<String> list = hash.get(key);
			for(String t: list){
				array[index] = t;
				index++;
			}
		}
	}

	
	
}
