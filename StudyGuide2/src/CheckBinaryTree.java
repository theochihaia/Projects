import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.tree.TreeNode;


public class CheckBinaryTree {
	public static void main (String [] args){
		
	}
	
	
	/*
	 * Implement a function to check if a binary tree is balanced
	 * 		def: balanced is where the hieght of the two subtrees of any node differ more than 1
	 * 
	 */
	private static boolean isBalanced(TreeNode node){
		if(getHeight(node) == -1)
			return false;
		else
			return true;
	}
	
	private static int getHeight(TreeNode node){
		
		if (node == null){
			return 0;
		}
		
		Enumeration<TreeNode> children = node.children();
		
		while(children.hasMoreElements()){
			int nodeHeight = getHeight(children.nextElement());
			if (nodeHeight == -1){
				return -1;
			}
		}
		
		
		return 0;
	}
	
}
