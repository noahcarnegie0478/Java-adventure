package leetcode;

public class UniquePath {
	
	

	     public int uniquePaths(int m, int n) {
	       int[][] dpArray = new int[m][n];
	       int[] row = {0};
	       for (int i = 0; i < m ; i++) {
	         for (int j = 0; j < n; j++) {
	           if (i == 0 | j == 0) {
	             dpArray[i][j] = 1;
	           } else {
	             if (i != 0 && j != 0) {
	               dpArray[i][j] = dpArray[i -1][j] + dpArray[i][j - 1];
	             }
	           }
	         }

	         
	       }
	       return dpArray[m-1][n-1];
	    }
	

}
