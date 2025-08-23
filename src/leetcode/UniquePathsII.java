package leetcode;

public class UniquePathsII {
//  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//  if (obstacleGrid[0][0] == 1) return 0;
//    int m = obstacleGrid.length;
//    int n = obstacleGrid[0].length;
//    int[][] newArray = new int[m][n];
//    for (int i = 0; i < obstacleGrid.length; i++) {
//      for (int j = 0; j < obstacleGrid[i].length; j++) {
//      if (m == 1 ) {
//          if (obstacleGrid[i][j] == 1) return 0;
//      }
//      if (obstacleGrid[i][j] == 1)  newArray[i][j] = 0;
//      else if (i == 0 || j == 0 )  {
//        if (i == 0 && j >0 && newArray[i][j - 1] == 0  ) newArray[i][j] = 0;
//        else if (j == 0 && i > 0 && newArray[i - 1][j] == 0) newArray[i][j] = 0;
//        else {
//          newArray[i][j] = 1;
//        }

//      }
//      else  newArray[i][j] = newArray[i][j] = newArray[i -1][j] + newArray[i][j - 1];
//      }
//    }
//      return newArray[m-1][n-1];   
//  }
  public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
   if (obstacleGrid[0][0] == 1 || obstacleGrid == null)  return 0;
   int m = obstacleGrid.length;
   int n = obstacleGrid[0].length;
   int[] newArray = new int[n];
   newArray[0] = 1;
   for (int i = 0; i < m; i++) {
     for (int j =0; j < n; j++) {
       if (obstacleGrid[i][j] == 1) {
         newArray[j] = 0;
       }
       else {
         if (j > 0) newArray[j] = newArray[j] + newArray[j-1]; 
       }
     }
   }
   return newArray[n-1];
 
 }



}
