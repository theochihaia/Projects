import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class CarRace {
    private static BufferedReader buffer;

	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        buffer = new BufferedReader(new FileReader(file));
        String line;
        
        RaceTrack track = null;
        ArrayList<Car> cars = new ArrayList<Car>();
        HashMap<Integer,Float> runTimes = new HashMap<Integer,Float>();
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            
            /*
             * Initialization of Input
             */
            
            // Race Track Segments
            if(track == null){
            	track = new RaceTrack(line);
            }
            // Cars
            else {
            	cars.add(new Car(line));
            }
            
            
            /*
             * Calculations
             */
            for(Car c : cars){
            	float time = 0;
            	
            	Iterator<RaceTrackSegment> segments = track.iterator();
            	while(segments.hasNext()){
            		
            		c.getTraverseTime(segments.next());

            	}
            	
            	// add time to map
            	runTimes.put(c.carID, time);
            }
            
        }
    }
}


class RaceTrack implements Iterable<RaceTrackSegment>{
	
	ArrayList<RaceTrackSegment> segments;
	
	RaceTrack(){
		segments = new ArrayList<RaceTrackSegment>();
	}
	
	RaceTrack(String details){
		segments = new ArrayList<RaceTrackSegment>();
		
		String[] track_arry = null;
		track_arry = details.split(" ");
    	for(int i = 0; i < track_arry.length; i+=2){
    		this.addSegment(new RaceTrackSegment(Float.parseFloat(track_arry[i]), Integer.parseInt(track_arry[i+1])));
    	}
		
	}
	
	void addSegment(RaceTrackSegment seg){
		segments.add(seg);
		
	
	}

	public Iterator<RaceTrackSegment> iterator() {
		return segments.iterator();
	}
	
}

class RaceTrackSegment{
	float distance;
	int degreeTurn;
	
	// Distance in miles
	// Degree turn 0 => no slow-down | Degree turn 180 => full stop
	RaceTrackSegment(float distance, int degreeTurn){
		this.distance = distance;
		this.degreeTurn = degreeTurn;
	}
	
}

class Car{
	int carID;
	int maxSpeed;
	float decelerationTime;
	float accelerationTime;
	
	// Car speed in MPH
	Car(int carID, int maxSpeed, float decelTime, float acelTime){
		this.maxSpeed = maxSpeed;
		this.decelerationTime = decelTime;
		this.accelerationTime = acelTime;
	}
	
	Car(String details){
		String[] carDetails = details.split(" ");
		short ix = 0;
		this.carID = Integer.parseInt(carDetails[ix]);
		this.maxSpeed = Integer.parseInt(carDetails[ix+=1]);
		this.accelerationTime = Float.parseFloat(carDetails[ix+=1]);
		this.decelerationTime = Float.parseFloat(carDetails[ix+=1]);
	}
	
	// returns time to traverse track in seconds
	float getTraverseTime(RaceTrackSegment segment){
		
		return 0;
	}
	
	float getGoalMPH(){
		return (float) 0.0;
	}
	
}