
public class SearchMatrix {

	static Coordinate pnt = new Coordinate(0,0);
	
	public static void main(String [] args){
		
		int[][] matrix = {
							{15, 20, 40, 40}
							,{20,35, 80, 95}
							,{30,55,95,105}
							,{40,80,100,120}
						};
		
		
		
		
		System.out.println("Matrix :");
		
		for(int x = 0; x < matrix.length; x++){
			for(int y = 0; y<matrix[0].length; y++){
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
	public static Coordinate findElement(int[][] matrix, int val){
		
		int pointValue = getValue(matrix,pnt);
		
		if(pointValue == val){
			return pnt;
		}
		
		if(pointValue > val){
			pnt.moveRightDiagonally();
			search(matrix,pnt,val);
		}else if(pointValue > val){
			Coordinate pntLeft = pnt.getLeft();
			if (getValue(matrix,pntLeft) < val){
				linearSearchDown(matrix,pntLeft);
			}else if (getValue(matrix,pnt.getAbove()) < val){
				linearSearchAbove(matrix,pnt.getAbove());
			}
			
			
		}
		
		
		return pnt;
	}
	
	public static boolean search(int[][] matrix, Coordinate pnt, int value){
		
		
		
		return false;
	}

	
	static int getValue(int[][] matrix, Coordinate pnt){
		return matrix[pnt.x][pnt.y];
	}
	
	static class Coordinate{
		int x;
		int y;
		Coordinate(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		void moveRightDiagonally(){
			this.x--;
			this.y--;
		}
		
		Coordinate getLeft(){
			return new Coordinate(x--,y);
		}
		
		Coordinate getAbove(){
			return new Coordinate(x,y++);
		}
		
	}
	
}
