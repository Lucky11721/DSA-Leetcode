class Solution {
    public boolean isValidSudoku(char[][] arr) {
        
        // chseck row
        for(int row = 0 ; row < 9 ; row ++){
            Set<Character> set = new HashSet<>();
            for(int col = 0 ; col <  9 ; col++){
                if(arr[row][col] =='.') continue;
                if(set.contains(arr[row][col])) return false;
                set.add(arr[row][col]);
            }
        }

         // chseck col
        for(int col = 0 ; col < 9 ; col ++){
            Set<Character> set = new HashSet<>();
            for(int row = 0 ; row <  9 ; row++){
                if(arr[row][col] =='.') continue;
                if(set.contains(arr[row][col])) return false;
                set.add(arr[row][col]);
            }
        }

        // 3* 3 sub matrix


        for(int startrow = 0 ; startrow < 9 ; startrow += 3  ){
            int endrow = startrow + 9/3;
            for(int startcol = 0 ; startcol < 9 ; startcol += 3){
                int endcol = startcol + 9/3;
                if(helper(arr , startrow , endrow , startcol , endcol) == false) return false;
            }
        }
        return true;
    }

    public boolean helper(char[][] arr , int sr , int er , int sc, int ec){
        Set<Character> set = new HashSet<>();
        for(int i = sr ; i < er ; i++){
            for(int j = sc ; j < ec ; j++){
                if(arr[i][j] == '.') continue;
                if(set.contains(arr[i][j])) return false;
                set.add(arr[i][j]);
            }
        }

        return true;
    }
}