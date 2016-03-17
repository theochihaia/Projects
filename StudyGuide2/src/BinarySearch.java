
public class BinarySearch {

	public static void main (String [] args){
		int num[] = { 1,5,7,23,55,59,98,120 };
		// int num2[] = {23,43,12,43,1,2,4,645,23,90};
		int find = 23;
		
		System.out.println("Index of Value " + find + " is " + binarySearch(num,find));
		System.out.println("Index of Value " + find + " is " + binarySearchRecursive(num,find,0,num.length));
	}
	
	
	static int binarySearch(int[] a, int x){
		int low = 0;
		int high = a.length - 1;
		int mid;
		while(low <= high){
			mid = (low + high)/2;
			if(a[mid] < x){
				low = mid + 1;
			}else if (a[mid] > x){
				high = mid - 1;
			}else{
				return mid;
			}	
		}
		return -1;
	}
	
	
	static int binarySearchRecursive(int[] a, int x, int low, int high){
		if(low>high){
			return -1;
		}		
		int mid = (low+high) / 2;
		if(a[mid] < x){
			return binarySearchRecursive(a,x,mid+1,high);
		}else if(a[mid] > x){
			return binarySearchRecursive(a,x,low,mid-1);
		}else{
			return mid;
		}
	}
	
	
}
