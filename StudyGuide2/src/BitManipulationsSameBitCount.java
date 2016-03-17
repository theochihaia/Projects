/*
 * ORIGINAL:  0011011001111100
 * CONVERTED: 0011011010001111
 * 
 * 
 */



public class BitManipulationsSameBitCount {

	public static void main(String [] args){
		int num = 13948;
		System.out.println("Initial Num: " + num);
		System.out.println("Next Num: " + getNext(num));
	}
	
	public static int getNext(int n){
		/* Compute c0 and c1 */
		
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		
		// GET COUNT OF TRAILING 0s
		while (((c & 1) == 0) && (c != 0)){
			c0++;
			c >>= 1;
		}
		
		// GET COUNT OF 1s
		while ( ( c & 1 ) == 1){
			c1++;
			c >>= 1;
		}
		
		
		/* Error: if n == 11.11000.00, then there is no bigger number with the same num of 1's */
		
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		
		int p = c0 + c1; // position of rightmost non-trailing zero
		
		n |= (1<<p);					// Turn value at most non-trailing 0 into a 1
		n &= ~((1 << p) -1);			// Clear all the values of before the most non-trailing 0
		n |= (1 << (c1 - 1)) - 1;		// Add (cnt of 1s) 1s to the end of the new cleared number
		return n;

	}
	
	
	public static int getPrevious(int n){
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		
		// calculate the number of trailing 1s
		while ((( temp & 1) == 1) && temp != 0){
			c1++;
			temp >>= 1;
		}
		
		// if no ones, then there is no smaller number
		if( temp == 0) return -1;
		
		while ((temp &1) == 0 && (temp != 0)){
			c0++;
			temp >>=1 ;
		}
		
		int p = c0 + c1;
		n &= ((~0) << (p+1));
		
		int mask = (1 << (c1 + 1)) - 1;
		n |= mask << (c0 - 1);
		
		return n;
	}
	
	
	
	
}
