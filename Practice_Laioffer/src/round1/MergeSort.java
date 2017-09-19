package round1;

public class MergeSort {
	public int[] mergeSort (int[] array) {
		if (array == null){ //无所谓|| array.length == 1) {
			return array;
		}
		int[] helper=new int[array.length];
		mergeSort(array,helper,0,array.length-1);
		return array;
	}

	private void mergeSort(int[] array, int[] helper, int left, int right) {
		// TODO Auto-generated method stub
		if (left>=right) {
			return;
		}
		int mid = left + (right-left)/2;
		mergeSort(array,helper,left,mid);
		mergeSort(array,helper,mid+1,right);
		merge(array,helper,left,mid,right);
		
	}

	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		// TODO Auto-generated method stub
		for (int i=left;i<=right;i++) {
			helper[i]=array[i];
		}
		//copy array to helper
		int leftBound=left;
		int rightBound = mid+1;
		while (leftBound<=mid && rightBound <= right) {
			if (helper[leftBound]>helper[rightBound]) {
				array[left++]=helper[rightBound++];
			}else {
				array[left++]=helper[leftBound++];
			}
		}
		while (leftBound<=mid) {
			array[left++]=helper[leftBound++];
		}
		//while(rightBound) is not needed because array[left] is equal to helper[rightBound] and rest
		
	}
}