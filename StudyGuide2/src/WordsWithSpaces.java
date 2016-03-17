import java.util.HashMap;

/*
	Write a program that breaks up a string of words with no spaces into a string with the appropriate spaces?
*/
		
public class WordsWithSpaces {
	static String[] words = {"Long","Live","ATB","the","greatest","DJ","ON","Earth","Mars","Let's","DO","This","I","reiterate","peanut","butter","peanutbutter","pea","nut"};
	// static String input =  "LongLiveATBthegreatestDJONEarthIreiterate";
	static String input =  "LongLiveATBthegreatestDJ";
	public static void main(String [] args){
		
		//Load the works in datasource
		//iterate through characters. Do iteration while next letter does not exist in dictionary.
		
		HashMap<String,String> tree = getDictionary(words);
		
		StringBuilder output = new StringBuilder();
		int inputLength = input.length();
		int ix = 0;
		do{
			int subStringStart = ix;
			int subStringEnd = ix + 1;
			while (subStringStart != subStringEnd){
				String substring = input.substring(subStringStart, subStringEnd);
				// this should get an array of words like 'word%' and then iterate through list until size return is 1
				if (tree.get(substring) != null){
					output.append(" " + substring);
					subStringStart = subStringEnd;
					ix = subStringEnd;
				}else{
					subStringEnd ++;
				}
			}
				
		}while ( ix < inputLength);
		
		System.out.println(output);
	}
	
	public static HashMap<String, String> getDictionary(String[] words){
		HashMap<String,String> map = new HashMap<String,String>();
		for(String s:words){
			map.put(s, "");
		}
		return map;
	}
	
	

}






/*

Questions:
	How am I receiving the dictionary or words? (do I parse it, is it an array?)
	What is the range that input string can me?
	Are there duplicates in input data?
	
	
	
*/