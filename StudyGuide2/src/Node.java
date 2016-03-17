import java.util.HashMap;
import java.util.HashSet;


public class Node {
	
	Node next = null;
	int data;
	
	public Node(int d){
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null){
			n = n.next = end;
		}
		n.next = end;
	}
	
	Node deleteNode(Node head, int d){
		Node n = head;
		
		if(n.data == d){
			return head.next;
		}
		
		while (n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}

		return head;
	}
	
	
	Node removeDuplicates(Node head){
		
		HashSet set = new HashSet();
		
		Node n = head;
		
		
		while(n.next != null){
			if(set.contains(n.data)){
				n.next = n.next.next;
			} else {
				set.add(n.data);
			}
			
			n = n.next;
		}
		
		return head;
	}
	
	
	Node findKthToLast(Node head, int k){
		Node n = head;
		Node kthElement = head;
		int ix = 0;
		
		// iterate through elements
		while (n.next != null){
			// do not iterate until k iterations have passed
			if( ix >= k)
				kthElement = kthElement.next;
			
			// Iterate
			ix++;
			n = n.next;
			
		}
		return (ix >= k) ? kthElement : null;

	}
	
	
	public Node partition(Node node, int x){
		
		Node beforeStart = null;
		Node afterStart = null;
		
		/* Partition List */
		
		while (node != null){
			Node next = node.next;
			if(node.data < x){
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;
			}
			else {
				/* Insert node into from of after list */
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
			
		}
		
		/* Merge before list and after list */
		if(beforeStart == null){
			return afterStart;
		}
		
		/* Find end of before list, and merge the lists */
		Node head = beforeStart;
		while (beforeStart.next != null){
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		
		return head;
	}
	

}
