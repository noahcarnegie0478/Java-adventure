package leetcode;


//
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
//representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
//To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
//and the last n elements are set to 0 and should be ignored. nums2 has a length of n.


public class MergeSortedArray {
	public static void main (String[] args) {	
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		merge(nums1, 3, nums2,3);
	}
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	       for (int i = 0; i<n; i++) {
	            nums1[m + i] = nums2[i];
	        }
	        nums1 = sort(nums1);
	    }
	    public static int[] sort(int[] newArray) {
	            for (int i = 0; i < newArray.length; i++) {
	            for (int j = i + 1; j < newArray.length; j++) {
	                int current = 0;
	                if (newArray[j] < newArray[i]) {
	                    current = newArray[i];
	                    newArray[i] = newArray[j];
	                    newArray[j] = current;
	                }
	            } 
	        }
	        return newArray;
	    }
	
	
}
