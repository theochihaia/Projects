
public class BitManipulation {
	
	public static void main(String [] args){
		
		//0110
		System.out.println(getBit(5,7));
		
		System.out.println(setBit(5,8));
		
		System.out.println(clearBit(7,2));
		
	}
	
	static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	static int setBit(int num, int i){
		return num | (1 << i);
	}
	
	static int clearBit(int num, int i){
		int mask = ~(1 << i);
		return num & mask;
	}
	
	static int updateBit(int num, int i, int v){
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
	}
	
	
}
