import java.awt.Color;
import java.awt.Point;


public class PaintFill {

	public static void main(String [] args){
		
		
		// paintFill(int[][] screen, )
		
		Color col_orig = Color.WHITE;
		Color col_new = Color.BLUE;
		Color[][] scrn = new Color[10][10];
		
		for(int x = 0; x< scrn.length; x++){
			for(int y = 0; y<scrn.length; y++){
				if(x%2 == 0)
					scrn[x][y] = col_orig;
				else
					scrn[x][y] = Color.red;
			}
		}
		
		
		paintFill (scrn, new Point(5,5), col_new, col_orig );
		
		for(int x = 0; x< scrn.length; x++){
			for(int y = 0; y<scrn.length; y++){
				System.out.print("(" + x + "," + y + ") ");
				System.out.print(scrn[x][y].toString() + " || ");
			}
			System.out.println();
		}
		
		
	}
	
	// fill surrounding area until color changes from orginal color
	public static boolean paintFill (Color[][] screen, Point pnt, Color col_new, Color col_orig ){
		
		if ( pnt.getX() < 0 || pnt.getY() < 0 
			|| pnt.getX() >= screen.length || pnt.getY() >= screen.length){
			return false;
		}

		if(screen[(int) pnt.getX()][(int) pnt.getY()] == col_orig){
			screen[(int) pnt.getX()][(int) pnt.getY()]  = col_new;
			
			paintFill(screen, new Point((int) pnt.getX()-1, (int) pnt.getY()-1), col_new,col_orig);
			paintFill(screen, new Point((int) pnt.getX()+1, (int) pnt.getY()+1), col_new,col_orig);
			paintFill(screen, new Point((int) pnt.getX(), (int) pnt.getY()-1), col_new,col_orig);
			paintFill(screen, new Point((int) pnt.getX()-1, (int) pnt.getY()), col_new,col_orig);
			
		}
			
		
		
		
		return true;
	}
	
}
