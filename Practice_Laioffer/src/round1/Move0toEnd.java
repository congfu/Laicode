//Given an array of integers, move all the 0s to the right end of the array.
//
//The relative order of the elements in the original array does not need to be maintained.
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

package round1;

public class Move0toEnd {
	public int[] moveZero(int[] array) {
		if (array.length<=1) {
			return array;
		}
		int start = 0;
		int end= array.length-1;
		while (start<=end) {
			if (array[start]==0) {
				swap(array,start,end--);
			}else {
				start++;
			}
		}
		return array;
		
	}
	  private void swap (int[] array, int a, int b) {
		    int tmp= array[a];
		    array[a] = array[b];
		    array[b] = tmp;
		  }
}
