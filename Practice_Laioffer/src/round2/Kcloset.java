//Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.
//
//Assumptions
//
//A is not null
//K is guranteed to be >= 0 and K is guranteed to be <= A.length
//Return
//
//A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T. 
//Examples
//
//A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
//A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

package round2;

public class Kcloset {
	 public int[] kClosest(int[] array, int target, int k) {
		    int[] result = new int[k];
		    if(array.length==0 ||k==0){
		       return result;  
		    }
		    int left = largestSmallest(array,target);
		    int right = left+1;
		    
		    for (int i= 0; i< k ;i++){
		       if (right >= array.length || left >=0 && target - array[left] <= array [right] - target) {
		          result[i] = array[left--];
		    }else{
		       result[i] = array[right++];
		    }
		    }
		    return result;
		   
		  }
	 //先找到最closet的 然后左右+1对比 直到到k或者超出边界
		    
		  private int largestSmallest(int[] array, int target){
		    int left = 0;
		    int right = array.length-1;
		    while (left < right -1){
		      int mid = left + (right-left)/2;
		      if (array[mid]<= target){
		        left=mid;
		      }else{
		        right=mid;
		      }
		    }
		    if (array[right]<=target){ // return the largest smaller or euqal element, so when we compare left and left+1 (right) we compare wont miss any elements
		      return right;
		    }else  if(array[left]<=target){
		      return left;
		  }
		  //cannot find ---> print array from left to right (-1+1 =0)
		  return -1;
		}
}
