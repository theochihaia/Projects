
public class PrintBinary {

	public static void main(String [] args){
		
		// double num = .9375;
		double num = .625;
		System.out.println("Binary Represenation of " + num + " is " + printBinary(num));
	}
	
	public static String printBinary(double num){
		
		if(num >=1 || num <=0){
			return "Error";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0){
			if (binary.length() > 64){
				return "ERROR";
			}
			
			double r = num * 2;
			
			if( r >= 1){
				binary.append(1);
				num = r-1;
				
			} else {
				binary.append(0);
				num = r;
			}
			
			
		}
		
		return binary.toString();
	}
	
}
