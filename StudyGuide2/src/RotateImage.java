
public class RotateImage {

	
	public static void main (String [] args){
		
		int[][] list = { 
							{5 ,7, 8} 
							,{3,9,10}
							,{2,1,4}
						};
		
		rotate(list,3);
		
		for( int[] l1 : list){
			for( int num : l1)
				System.out.print(num + " ");
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix, int n){
		
		for (int layer = 0; layer <= n /2; layer ++){
			int first = layer;
			int last = n - 1 - layer;
			
			for( int i = first; i < last; i++ ){
				int offset = i - first;
				
				// save top
				int top = matrix[first][i];
				
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top;
				
			}
			
			
		}
		
		
	}
	
	
}
