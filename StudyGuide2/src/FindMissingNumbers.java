import java.util.ArrayList;


public class FindMissingNumbers {

	public static void main (String [] args){
		
	}
	
	public int findMissing(ArrayList<BitInteger> input, int column){
		
		return findMissing(input, BitInteger.INTEGER_SIZE - 1);
		
	}
	
	public int findMissingSetup(ArrayList<BitInteger> input, int column){
		if(column < 0){
			return 0;
		}
		
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size()/2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size()/2);
		
		for(BitInteger t : input){
			if(t.fetch(column) == 0){
				zeroBits.add(t);
			} else {
				oneBits.add(t);
			}
		}
		if(zeroBits.size() <= oneBits.size()){
			int v = findMissingSetup(zeroBits, column - 1);
			return (v << 1) | 0;
		} else {
			int v = findMissingSetup(oneBits, column - 1);
			return (v << 1) | 1;
		}
	}
	
}
