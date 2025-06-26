package leetcode;

public class SearchRotatedSortedArrayII {
	
	
//	There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
//
//	Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) 
//	such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
//	For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
//
//	Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
//
//	You must decrease the overall operation steps as much as possible.
	
	public static void main (String[] args) {
		int[] nums = {0,0,1,1,2,0};
		System.out.println(search(nums, 2));;
	}
	
	 public static boolean search(int[] nums, int target) {
	        int left =0;
	        int right = nums.length - 1;
	        int mid =0;
	        while (left <= right) {
	            mid = left + (right - left) /2;
	           
	            if (nums[mid] == target| nums[left] == target | nums[right] == target ) return true;
	            if (nums[left] == nums[mid] && nums[right] == nums[mid] ) {
	                left++;
	                right--;
	            }
	            else if (nums[mid] >= nums[left] && target < nums[mid]) {
	                if (target > nums[left]) {
	                    right = mid -1;
	                }
	                else {
	                    left = mid +1;
	                }
	            }
	            else if (nums[mid] <= nums[right] && target > nums[mid])  {
	                if (target < nums[right]) {
	                    left = mid +1;
	                }
	                else {
	                    right = mid -1;
	                }
	            }
	            else {
	                left++;
	                right--;
	            }   
	        }
	        return false;
	    }

}
