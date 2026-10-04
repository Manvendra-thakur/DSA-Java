class Solution {
    public int[][] generateMatrix(int n) {
       int result[][] = new int[n][n];
      
       int top = 0, bottom = n-1;
       int left = 0, right = n-1;
       int ele = 1;
      
       while(ele<=n*n){
        for(int i = left;i<=right;i++){
            result[top][i] = ele++;
        }
        top++;
         for(int i = top;i<=bottom;i++){
            result[i][right] = ele++; 
         }
        right--;
          if(top<=bottom){
              for(int i = right;i>=left;i--){
                 result[bottom][i] = ele++;   
              }
            bottom--;
        }
           if(left<=right){
             for(int i = bottom;i>=top;i--){
                 result[i][left] = ele++;  
            }
            left++;
        }
       }
       return result;

    }
}