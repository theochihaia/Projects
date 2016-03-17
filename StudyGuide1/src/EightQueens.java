import java.util.ArrayList;


public class EightQueens {
	
	
	static final int GRID_SIZE = 8;
	public static void main(String [] args){
		Integer[] columns = new Integer[8];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		int row = 0;
		placeQueens( row, columns,results);
		
		for(Integer[] poss : results){
			for(int i = 0; i < GRID_SIZE; i++)
				System.out.print(poss[i] + " ");
			
			System.out.println();
			
		}
			
		
	}
	
	static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
		
		// found valid placement
		if( row == GRID_SIZE){
			results.add(columns.clone());
		}else{
			
			for(int col = 0; col < GRID_SIZE; col++){
				
				if(checkValid(columns, row, col)){
					columns[row] = col; // place queen
					placeQueens(row + 1, columns, results);
				}
				
			}
			
		}
	}

	
	/* Check if (row1,column1) is a valid spot for a queen by checking if there is a queen in the same column or diagonal.
	 * We don't need to check it for queens in the same row because the calling placeQueen only attempts to place one queen at a time.
	 * we know this row is empty.
	 */
	private static boolean checkValid(Integer[] columns, int row1, int column1) {
		
		for(int row2 = 0; row2 < row1; row2++){
			int column2 = columns[row2];
			/* Check if (row2, column2) invalidates (row1, column1) as a queen spot */
			
			if(column1 == column2){
				return false;
			}
			
			/* Check diagonals: if the distance between the columns equals the distance between the rows,
			 * then they're in the same diagonal
			 */
			int columnDistance = Math.abs(column2 - column1);
			
			/* row1 > row2 so no need for abs */
			
			int rowDistance = row1 - row2;
			if(columnDistance == rowDistance){
				return false;
			}
		}

		return true;
	}
	
}
