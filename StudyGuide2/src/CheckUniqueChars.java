import java.util.Arrays;


public class CheckUniqueChars {
	
	public static void main (String [] args){
		
		// System.out.println(isPermutation("cat", "btc"));
		
		String s = "this is a test";
		char[] tmp = s.toCharArray();
		char[] theString = new char[100];
		
		for(int i = 0; i < tmp.length; i++){
			theString[i] = tmp[i];
		
		}
		
		System.out.println(replace(theString, "WOOTWOOT", tmp.length ));
		
	}
	
	public boolean isUniqueChars(String str){
		
		final int ASCII_LEN = 256;
		if (str.length() > ASCII_LEN)
			return false;
		
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < ASCII_LEN; i++)
		{
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	
	public boolean isUniqueChars_Bit(String str){
		
		int checker = 0;
		
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 'a';
			if( (checker & ( 1 << val)) > 0 )
				return false;
			
			checker |= ( 1 << val);
		}
		
		return true;
	}
	
	public static boolean isPermutation(String str1, String str2){
		
		if (str1.length() != str2.length())
			return false;
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		for(int i = 0 ; i < c1.length; i++){
			if (c1[i] != c2[i])
				return false;
		}
		
		return true;
	}
	

	public static boolean isPermutation_Lookup(String str1, String str2){
		
		if(str1.length() != str2.length())
			return false;
		
		int[] letters = new int[256];
		
		char[] arry_str1 = str1.toCharArray();
		for(char c: arry_str1){
			letters[c] ++;
		}
		
		for(int i = 0; i < str2.length(); i ++){
			int c = (int) str2.charAt(i);
			if(letters[c--] < 0){
				return false;
			}
		}
		
		return true;
	}
	
	
	static public char[] replace(char[] str, String replacement, int len ){

		int cnt_spaces = 0;
		int newLength;
		
		for(int i = 0; i < len; i++){
			if (str[i] == ' ')
			cnt_spaces ++;
		}
		 
		newLength = len + cnt_spaces * (replacement.length() - 1);
		
		for(int i = len; i > 0; i--){
			
			char c = str[i];
			
			if(c == ' '){
				
				for(int x = replacement.length()-1; x >= 0 ; x--){
					str[newLength - (replacement.length()-1) + x] = replacement.charAt(x);
					
				}
				newLength -= replacement.length();

				
			} else {
				str[newLength] = c;
				newLength--;
			}
			
		}
		return str;
	}
	

}
