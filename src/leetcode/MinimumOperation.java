package leetcode;

public class MinimumOperation {
	public static void main(String[] args) {
		int[] nums = {1,1,1};
		System.out.println("result : " +  minOperations(nums));
		
	}
	 public  static int minOperations(int[] nums) {
	        int toBeReturn = 0;
	        int lengthList = nums.length;
	        for (int i = 0; i + 1 < lengthList; i++ ) {
	            if (nums[i] >= nums[i+1]) {
	               toBeReturn = toBeReturn + ( nums[i] + 1 - nums[i + 1]);
	                nums[i+ 1] = nums[i] + 1;
	            }
	        }
	        
	        return toBeReturn;
	        

	    }

}
