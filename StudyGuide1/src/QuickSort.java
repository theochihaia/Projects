
public class QuickSort {

	public static void main(String [] args){
		
		int[] list = {1,2,8,4,5,9};
		quickSort(list,0,list.length-1);
		
		for(int num : list)
			System.out.print(num + " ");
		
	}
	
	static void quickSort(int arr[], int left, int right){
		int index = partition(arr, left, right);
		
		if(left < index - 1){
			quickSort(arr, left, index - 1);
		}
		if(index < right){
			quickSort(arr, index, right);
		}
		
		
	}
	
	static int partition(int arr[], int left, int right){
		int pivot = arr[(left + right)/2];
		while(left<=right){
			while(arr[left] < pivot)
				left++;
			
			while (arr[right] > pivot)
				right--;
			
			if(left <= right){
				swap(arr,left,right);
				left++;
				right--;
			}
		}
		
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
	
	
}
