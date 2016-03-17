import java.util.TreeSet;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;


public class MinimalBST {
	public static void main (String [] args){
		
		int[] list = {1,2,4,5,9,1,8};
		createMinimalBST(list,1,10);
		
	}
	
	private static TreeNode createMinimalBST(int arr[], int start, int end){
		if(end<start){
			return null;
		}
		int mid = (start+end) / 2;
		
		TreeSet n = new TreeSet();
		
		
		return null;
	}
}
