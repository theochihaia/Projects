import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class LongestWord {
	
	public static void main (String [] args){
		
		String[] myList = {"hey", "what's", "going","on","zz","e"};
		getLongestWords(myList);
		// System.out.println();
	}
	
	static String getLongestWords(String[] list){
		
		TreeSet<String> list2 = getOrderedList(list);
		
		
		// Arrays.sort(list); // , new CompareList());
		Arrays.sort(list, new CompareList());
		
		for(String s: list){
			System.out.println(s + " ");
		}
		
		
		return list2.last();
		
	}
	
	private static TreeSet<String> getOrderedList(String[] list){
		TreeSet<String> tree = new TreeSet(new CompareList());
		
		for(String s : list){
			tree.add(s);
		}
		
		return tree;
	}

}
class CompareList implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return -1 * (o1.length() - o2.length()) ;
	}
}  
