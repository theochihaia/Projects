
public class MergeListsSorted {

	public static void main(String[] args) {
		
		int[] a = {1,3,4,5,6,23,54,65,92,234,435,0,0,0,0,0,0};
		int[] b = {3,5,6,9,10,35};
		int[] output = new int[a.length-1];
		
		// mergeListsRecursive(a, b, a.length - b.length - 1, b.length-1 );
		merge(a, b, a.length - b.length , b.length );
		
		for(int num : a)
			System.out.println(num + " ");
	}
	
	static void mergeListsRecursive(int[] a, int[] b, int A_ix, int B_ix){
		
		int current_IX = A_ix + B_ix + 1;
		
		if(B_ix < 0 || A_ix < 0){
			return;
		}
		if(a[A_ix] > b[B_ix]){
			a[current_IX] = a[A_ix];
			mergeListsRecursive(a, b, A_ix-1 , B_ix );
		}else if(a[A_ix] < b[B_ix]){
			a[current_IX] = b[B_ix];
			mergeListsRecursive(a, b, A_ix, B_ix-1 );
		}else if (a[A_ix] == b[B_ix]){
			a[current_IX] = a[A_ix];
			a[current_IX-1] = b[B_ix];
			mergeListsRecursive(a, b, A_ix-1, B_ix-1 );
		}	
	}
	
	
	static void merge(int[] a, int[] b, int lastA, int lastB){
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastB + lastA - 1;
		
		while(indexA >= 0 && indexB >= 0){
			
			if(a[indexA] > b[indexB]){
				a[indexMerged] = a[indexA];
				indexMerged--;
				indexA--;
			}else{
				a[indexMerged] = b[indexB];
				indexMerged--;
				indexB--;
			}
			
		}
		
		while (indexB >= 0){
			a[indexMerged] = b[indexB];
			indexMerged--;
			indexB--;
		}
		
		
	}

}
