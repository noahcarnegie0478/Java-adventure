package leetcode;

public class RemoveElement {
	
	
//	Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. 
//	Then return the number of elements in nums which are not equal to val.
//
//			Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//
//			Change the array nums such that the first k elements of nums contain the elements which are not equal to val. 
//			The remaining elements of nums are not important as well as the size of nums.
//			Return k.
	public static void main (String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		removeElement(nums, 2);
	}
	 public static int removeElement(int[] nums, int val) {
	        int countK = 0;
	        for (int i = 0; i < nums.length; i++ ) {
	            if (nums[i] != val) {
	                nums[countK] = nums[i];
	                countK++;
	            }
	            
	        }
	        return countK;
	    }
	

}
