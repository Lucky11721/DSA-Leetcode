class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
       
          int minrow = 0;
        int maxrow = arr.length - 1;
        int  mincol = 0;

        List<Integer> ans = new ArrayList<>();
        int maxcol = arr[0].length  - 1;
        while(minrow <= maxrow && mincol <=maxcol){
        
       // Left to Right  Printing of Elements
        // Loop through each column in the current row
        for(int j = mincol ; j<= maxcol ; j++){
            ans.add(arr[minrow][j]);
        }
        // Move to the next row
        minrow++;
  
        if(minrow > maxrow || mincol > maxcol){
            break;
        }
        // top to bottom
        // Loop through each row in the current column
        for(int i = minrow ; i <= maxrow ; i++){
            ans.add(arr[i][maxcol]);
        }
        // Move to the previous column
        maxcol--;
       
        if(minrow > maxrow || mincol > maxcol){
            break;
        }

        // right to left
        // Loop through each column in the current row in reverse order
        for(int j =  maxcol  ;  j >= mincol ; j-- ){
           ans.add(arr[maxrow][j]);
        }
        // Move to the previous row
        maxrow--; 
       
        if(minrow > maxrow || mincol > maxcol){
            break;
        }
      //  bottom to top
      // Loop through each row in the current column in reverse order
        for(int i = maxrow; i >=minrow ; i--){
            ans.add(arr[i][mincol]);
        }
        // Move to the next column
        mincol++;
        
    }
    
       return ans;
        
    }
}