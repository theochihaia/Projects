import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public class CashRegister {
	private static BufferedReader buffer;
    static Double[] coins = {100.0,50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.25,0.1,.05,.01};
    final static String ERROR = "ERROR,";
    final static String ZERO = "ZERO,";
    static HashMap<Double,String> dict;
    
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        buffer = new BufferedReader(new FileReader(file));
        String line;
        
        init();
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            int ix_encoding = line.indexOf(';');

            BigDecimal cost = BigDecimal.valueOf(Double.parseDouble(line.substring(0,ix_encoding)));
            BigDecimal paid = BigDecimal.valueOf(Double.parseDouble((line.substring(ix_encoding+1,line.length()))));

            
            System.out.println(getCoinText(cost, paid));
        }
    }
	
	static void init(){
        dict = new HashMap<Double,String>();
        dict.put(.01,"PENNY");
        dict.put(.05,"NICKEL");
        dict.put(.10,"DIME");
        dict.put(.25,"QUARTER");
        dict.put(.5,"HALF DOLLAR");
        dict.put(1.0,"ONE");
        dict.put(2.0,"TWO");
        dict.put(5.0,"FIVE");
        dict.put(10.0,"TEN");
        dict.put(20.0,"TWENTY");
        dict.put(50.0,"FIFTY");
        dict.put(100.0,"ONE HUNDRED");
	}
	
	public static String getCoinText(BigDecimal cost, BigDecimal paid){
		init();
		BigDecimal change = paid.subtract(cost);
		StringBuilder str = new StringBuilder();
        if(change.compareTo(BigDecimal.ZERO) < 0)
        	str.append(ERROR);
        else if(change.compareTo(BigDecimal.ZERO) == 0)
        	str.append(ZERO);
        else
            while (change.compareTo(BigDecimal.valueOf(0.01)) >= 0){
            	
            	for(double coin : coins){
            		if(change.compareTo(BigDecimal.valueOf(coin)) >= 0)
            		{
            			change = change.subtract(BigDecimal.valueOf(coin));
            			str.append(dict.get(coin) + ",");
            			break;
            		}
            	}
            }


		
		
		return str.toString().substring(0, str.length()-1);
	}

}
