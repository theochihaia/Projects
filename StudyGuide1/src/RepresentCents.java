
public class RepresentCents {

	public static void main(String[] args) {
		
		System.out.println("Numbers of ways to make change " + makeChange(5, 25));

	}
	
	private static int makeChange(int amount, int denomination){
		

		
		int denomination_next = 0;
		
		switch(denomination){
		case 25:
			denomination_next = 10;
			break;
		case 10:
			denomination_next = 5;
			break;
		case 5:
			denomination_next = 1;
			break;
		case 1:
			return 1;
			
		}
		
		int ways = 0;
		
		for(int i = 0; i * denomination <= amount; i++){
			ways += makeChange( amount - i * denomination, denomination_next);
		}
		
		
		return ways;
	}

}
