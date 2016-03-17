
public class MagicIndex {
	
	static int arr[] = {1,2,2,3,4,5,7,8,9,11,11,11,21,22};
	
	public static void main(String [] args){
		
		System.out.println( magicIndex(0,arr.length-1,arr) );
	}
	
	
	public static int magicIndex(int startIX, int endIX, int[] num){
		
		if(endIX<startIX || startIX < 0 || endIX >= num.length)
			return -1;
		
		int mid = (startIX + endIX) / 2;
		int midVal = num[mid];
		
		if(midVal == mid)
			return mid;
		
		//search left
		int leftIX = Math.min(mid-1, midVal);
		int left = magicIndex(startIX,leftIX,num);
		if(left > 0)
			return left;
			
		//search right
		int rightIX = Math.max(mid + 1,  mid);
		int right = magicIndex(rightIX, endIX, num);
		
		return right;


	}
	
	
}
