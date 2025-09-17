class Solution {
    public boolean isMatch(String s, String p) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = p.toCharArray();
        int n = arr1.length;
        int m = arr2.length;
       
       return helper(arr1 , arr2 , 0 , 0 , n  , m);
    }

    public boolean helper(char[] arr1 , char[] arr2 , int i , int j , int n  , int m){
        if(i == n && j == m) return true;
      if (j == m) return false;
        boolean first = false;
        if (i < n && j < m && (arr1[i] == arr2[j] || arr2[j] == '.')) {
    first = true;
}

        boolean take = false;
        boolean skip  = false;
       boolean normal = false;
        if(j + 1<  m && arr2[j +1 ] == '*'){
            skip = helper(arr1 , arr2 , i , j+2 , n , m);
            if(i < n & j < m && (arr1[i] == arr2[j] || arr2[j] == '.')){
                take = first && helper(arr1 , arr2 , i+1 , j , n , m);
            }
        }
        else{
          normal = first &&  helper(arr1 , arr2 , i+1 , j+1 , n , m);
        }

        return  normal || take || skip;
    }
}