package leetcode;

public 
class FindaPeakElement {
    public int[] findPeakGrid(int[][] mat) {
   int[][] newArray = new int[mat[0].length][2];
   int arrayLength = mat.length;
   int maxAtTheTime =0;
   for (int i = 0; i < mat[0].length; i++ ) {
     maxAtTheTime = findMax(newArray, 0, arrayLength, mat, i);
     
   }
   if (newArray.length == 1 ) return newArray[0];
   for (int i = 0; i < newArray.length; i++ ) {
  
     if (newArray[i][1] == 0 ) {

       if (mat[newArray[i][0]][newArray[i][1]] > mat[newArray[i][0]][newArray[i][1] + 1]  )
       { 
         return newArray[i];

       }
     }else if (newArray[i][1] == mat[0].length - 1 ) {
     
        if (mat[newArray[i][0]][newArray[i][1]] > mat[newArray[i][0]][newArray[i][1] - 1]  )
       { 

         return newArray[i];
       }
     } else {
  
        if ((mat[newArray[i][0]][newArray[i][1]] > mat[newArray[i][0]][newArray[i][1] - 1]) & 
             mat[newArray[i][0]][newArray[i][1]] > mat[newArray[i][0]][newArray[i][1] + 1])
       { 

         return newArray[i];
       }
     }
   }
   return null;
     
 }
 public int findMax(int[][] resource, int n, int length, int[][] originalArray, int i) {
   if (n >= originalArray.length ) {
     return 0;
   }
   int previousMax = findMax(resource, n + 1, length, originalArray,i);
   
   if (originalArray[n][i] > previousMax) {
     resource[i] = new int[] {n,i} ;
     previousMax = originalArray[n][i] ;
   }
   return previousMax;
 }


}