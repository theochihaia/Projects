import java.util.ArrayList;
import java.util.Set;


public class CombinationParenthesis {
	

	
	public static void main(String [] args){
		
		System.out.println(generateParens(3));
		
	}
	
	public static ArrayList<String> generateParens(int count){
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}

	private static void addParen(ArrayList<String> list, int leftRemain, int rightRemain,
			char[] str, int count) {
		
		// invalid state
		if(leftRemain < 0 || rightRemain < leftRemain)
			return;
		
		// no parens to add
		if(leftRemain == 0 && rightRemain == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		}else{
			
			if(leftRemain > 0){
				str[count] = '(';
				addParen(list,leftRemain - 1, rightRemain, str, count + 1);
			}
			
			if(rightRemain > leftRemain){
				str[count] = ')';
				addParen(list, leftRemain, rightRemain - 1, str, count + 1);
			}
			
		}

		
	}

}
