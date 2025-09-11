class Solution {
    List<List<String>> ans = new ArrayList<>();
    public int totalNQueens(int n) {
        char[][] arr = new char[n][n];

        for(int i = 0 ; i  < n ; i++){
            for(int j = 0 ; j <  n ; j++){
                arr[i][j] = '.';
            }
        }
        System.out.println(Arrays.deepToString(arr));
       helper(arr , 0 , n);
        return ans.size();
    }

    public void helper(char[][] arr , int row , int n){
     if(row >= n){
        List<String> temp = new ArrayList<>();
        for(int  i = 0 ; i < arr.length ; i++){
            String str = "";
            for(int j = 0 ; j < arr[0].length ; j++){
              str += arr[i][j];
            }
            temp.add(str);
        }
        ans.add(temp);
        return;

     }

     for(int col = 0 ; col < n ; col++){
        if(isValid(arr , row , col)){
            arr[row][col] = 'Q';
            helper(arr , row+1 , n);
            arr[row][col] = '.';
        }
     }
    }

    public boolean isValid(char[][] arr , int row , int col){

        for(int i = row ; i >= 0 ; i--){
            if(arr[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row , j = col ; i >= 0 && j>= 0 ; i-- , j--){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row , j = col ; i >= 0 && j < arr[0].length ; i-- , j++){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}