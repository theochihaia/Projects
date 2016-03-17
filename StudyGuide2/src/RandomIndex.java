
public class RandomIndex {
	public static void main (String [] args){
		
		
		int[] a = {5,3,2,1,58,9};
		int[] b = pickMRandomly(a,6);
		for(int num : b){
			System.out.print( num + " ");
		}
	}
	
	public static int rand(int lower, int higher){
		return  lower + (int) ( Math.random() * (higher - lower)) ;
		
	}
	
	public static int[] pickMRandomly(int[] original, int m){
		int[] subset = new int[m];
		int[] clone = original.clone();
		
		for(int i = 0; i < m; i++){
			int index = rand(i,m);
			subset[i] = clone[index];
			clone[index] = clone[i];
		}
		return subset;
	}
}
