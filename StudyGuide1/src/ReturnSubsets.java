import java.util.ArrayList;


public class ReturnSubsets {
	public static void main(String [] args){
		
	}
	
	ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
		
		
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		
		// computer 2^n
		int max = 1 << set.size();
		
		for(int k = 0; k < max; k++){
			ArrayList<Integer> subset = convertIntToSet(k,set);
			allsubsets.add(subset);
		}
		
		return allsubsets;
		
	}

	private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int k = x; k > 0; k >>= 1){
			if( (k & 1) == 1){
					subset.add(set.get(index));
			}
			index ++;
		}
		return subset;
	}
	
}
