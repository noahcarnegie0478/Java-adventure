package day25;

import java.util.*;
public class MergeIntervals {
	public int[][] addIntoArray (int[][] intervals, int[] value) {
	      int[][] newArray = new int[intervals.length + 1][2];
	      for (int i = 0; i < intervals.length; i++) {
	        newArray[i] = intervals[i];
	      }
	      newArray[newArray.length - 1] = value;
	      return newArray;
	    }
	    public int[][] merge(int[][] intervals) {
	      int[][] newArray = new int[0][0];
	        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
	        int[] previousMerge = new int[0];
	        for (int i = 0; i < intervals.length; i++ ){
	           if (previousMerge.length == 0) {
	             previousMerge = intervals[i];
	             newArray = addIntoArray(newArray, previousMerge);  
	           }else {
	              if (previousMerge[1] >=intervals[i][0] | previousMerge[1] >=intervals[i][1]  ) {
	              int minA = Math.min(previousMerge[0], previousMerge[1]);
	              int maxA = Math.max(previousMerge[0], previousMerge[1]);
	              int minB = Math.min(intervals[ i][0], intervals[ i][1]);
	              int maxB = Math.max(intervals[i][0], intervals[i][1]);
	              previousMerge = new int[] {Math.min(minA, minB), Math.max(maxA,maxB)} ;
	              newArray[newArray.length - 1] = previousMerge;
	            }else {
	              newArray = addIntoArray(newArray, intervals[i]);
	              previousMerge = intervals[i];
	            }
	             
	           }
	            
	        }
	        return newArray;}

}
