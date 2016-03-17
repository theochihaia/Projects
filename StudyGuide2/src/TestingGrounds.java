
public class TestingGrounds {
	public static void main (String [] args){
		System.out.println(add(5,7));
	}
	
	public static int add(int a, int b){
		if (b== 0) return a;
		int sum = a^b;
		int carry = (a & b ) << 1;
		return add(sum,carry);
	}
}

/*
	101
	111
	[2] 0010
	
	0010
	1010
	sum= [1010] = 10
	carry = 0100
	
	
	0100
	1010
	sum = [1100]
	carry = 0
*/