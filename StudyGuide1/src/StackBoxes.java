import java.util.ArrayList;
import java.util.HashMap;



public class StackBoxes {

	public static void main(String[] args) {
		

	}
	
	public ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stack_map){
		
		if(bottom != null && stack_map.containsKey(bottom)){
			return stack_map.get(bottom);
		}
		
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		
		for(int i = 0; i < boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], stack_map);
				int new_height = stackHeight(new_stack);
				if(new_height > max_height){
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		
		if(max_stack == null) 
			max_stack = new ArrayList<Box>();
		if(bottom != null)
			max_stack.add(0,bottom);
		stack_map.put(bottom, max_stack);
		
		return (ArrayList<Box>) max_stack.clone();
	}
	
	
	public ArrayList<Box> createStackR(Box[] boxes, Box bottom){
		
		int max_height = 0;
		
		ArrayList<Box> max_stack = null;
		for(int i = 0; i < boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				if(new_height > max_height){
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		
		if(max_stack == null){
			max_stack = new ArrayList<Box>();
		}
		
		if(bottom!=null){
			max_stack.add(0,bottom);
		}
		
		return max_stack;
	}

	private int stackHeight(ArrayList<Box> new_stack) {
		
		int height = 0;
		for(Box b : new_stack){
			height += b.height;
		}		
		return height;
	}

}

class Box{
	
	int depth;
	int width;
	int height;
	
	Box(int depth, int width, int height){
		this.depth = depth;
		this.width = width;
		this.height = height;
	}

	public boolean canBeAbove(Box bottom) {
		
		return this.width > bottom.width && this.height > bottom.height && this.depth > bottom.depth;
	}
	
}