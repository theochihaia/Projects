import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;


public class Recursion_TraverseGrid {
	static ArrayList<Point> list = new ArrayList<Point>();
	static Hashtable<Point,Boolean> cache = new Hashtable<Point,Boolean>();
	public static void main (String [] args){
		getPath(10,10,list,cache);
		
		System.out.println(list.toString());
	}
	
	public static boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache2){
		Point p = new Point(x,y);
		
		if(cache.containsKey(p))
			return cache.get(p);
		
		path.add(p);
		if(x == 0 && y == 0)
			return true;
		
		boolean success = false;
		if ( x >= 1 && isFree(x-1,y))
			success = getPath(x-1,y,path,cache2);
		
		if ( !success && y >= 1 && isFree(x,y-1))
			success = getPath(x,y-1,path,cache2);
		
		if(!success)
			path.remove(p);
		
		cache.put(p, success);
		
		return success;
	}

	private static boolean isFree(int x, int y) {
		boolean block = (x ==5 && y == 10) || (x==5 && y == 9) || (x == 5 && y == 8) || (x==5 && y == 7) || (x ==6 && y == 7) || (x == 7 && y == 7);
		return (x >= 0) && (y >= 0 ) && !block && (x <= 10) && (y <= 10 );
	}
	
}
