import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;
public class EfficientDelivery {
	
	final static boolean debug = false;
	static final int maxBoats = 5;
	static TreeSet<Shipment> schedule = new TreeSet<Shipment>();
	
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            
            int[] tankers = getTankers(line.trim());
            
            int totBarrels = Integer.parseInt(line.substring(line.indexOf("), ") + 3));
            
            int[] delivery = new int[tankers.length];
            determineSchedule(tankers, totBarrels, delivery);
            

            if(debug){
            	System.out.println("============================");
                System.out.println("Total Barrels: " + totBarrels );
                for(int i : tankers)
                	System.out.println("Tanker Capacity: " + i); 
                for(Shipment ship : schedule){
                	System.out.println(ship.toString());
                }
            }else{
            	
                for(Shipment ship : schedule){
                	System.out.print(ship.toString());
                }
                System.out.println();
            }

            schedule = new TreeSet<Shipment>();
            
        }
    }
    
    

    private static void determineSchedule(int[] tankers ,int totBarrels, int[] delivery) {

    	for(int i = 0; i < tankers.length; i++){
    		if(delivery[i] <= 6){
        		int[] del = delivery.clone();
        		del[i] += 1;
        		if( checkValidity(tankers,totBarrels,del) ){
        			schedule.add(new Shipment(del));
        		}
        		// if(delivery[i] <= 6 && !schedule.contains(new Shipment(del)))
        		if(delivery[i] <= 6 && !schedule.contains(new Shipment(del)))
        			determineSchedule(tankers ,totBarrels, del);
    		}

    	}

	}

    
    private static boolean checkValidity(int[] tankers ,int totBarrels, int[] delivery){
		int transAmount = 0;
    	for(int i = 0; i < tankers.length; i++){
    		transAmount += tankers[i] * delivery[i];
    	}
    	
    	return transAmount == totBarrels;
    }
    


	public static int[] getTankers(String s){
    	int ixEOL = s.indexOf(')');
    	String[] tmp = s.substring(1,ixEOL).split(",");
    	int[] intList = new int[tmp.length];
    	
    	for(int i = 0; i < tmp.length; i++){
    		intList[i]= Integer.parseInt(tmp[i]);
    	}
    	
    	return intList;
    }

   
    
}


class Shipment implements Comparable{
	int[] shiptment;
	Shipment(int[] shipment){
		this.shiptment = shipment;
	}
	
	int getShipment(int ix){ return this.shiptment[ix]; }

	public int compareTo(Object o) {
		int comparison = 0;
		Shipment arry = (Shipment) o;
		for(int i = 0; i < this.shiptment.length; i++ )
		{
			comparison = ( this.shiptment[i] - arry.getShipment(i)) * (this.shiptment.length - i);
		}
		return comparison;
	}

/*	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 1;
	} */
	
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append("[");
    	for(int i = 0; i < this.shiptment.length; i++){	
    		output.append(this.shiptment[i]);
    		if(i < this.shiptment.length - 1){
    			output.append(",");
    		}
    	}
    	output.append("]");
    	
		return output.toString();
		
	}
	
}


