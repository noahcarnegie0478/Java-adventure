package leetcode;

public class RemoveDuplicatesSortedArrayII {
	
//	
//	Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. 
//	The relative order of the elements should be kept the same.
//
//	Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. 
//	More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. 
//	It does not matter what you leave beyond the first k elements.
//
//	Return k after placing the final result in the first k slots of nums.
//
//	Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
	
	
	public static void main (String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int dupicateTime = removeDuplicates(nums);
		
	}
	  public static int removeDuplicates(int[] nums) {
	        int index = 1;
	        int seen = nums[0];
	        int count = 0;
	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] == seen) {
	                if (count <= 0) {
	                    count++;
	                    nums[index] = nums[i];
	                    index++;
	                }
	            }else {
	                count = 0;
	                seen = nums[i];
	                nums[index] = nums[i];
	                index++;
	            }
	        }
	        return index;
	    }
	

}
