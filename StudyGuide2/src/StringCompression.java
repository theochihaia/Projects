
public class StringCompression {
	
	public static void main (String [] args){
		
		System.out.println(compressString ("aabcccccaaa")) ;
		
	}
	
	public static String compressString(String str){
		StringBuilder output = new StringBuilder();
		int cnt = 0;
		char prev = (char) -1;
		int ix = 1;
		for(int i = 0; i < str.length(); i++ ){
			
			if (prev == str.charAt(i)){
				cnt ++;
			} else {
				output.append(prev);
				output.append(cnt);
				prev =  str.charAt(i);
				cnt = 1;
			}
			
		}
		
		output.append(prev);
		output.append(cnt);
		
		return output.toString().substring(2);
	}

}
