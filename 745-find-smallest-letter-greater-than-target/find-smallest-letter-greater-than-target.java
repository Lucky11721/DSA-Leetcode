class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        int n = arr.length;
        int[] ascii = new int[n];

        for(int i = 0 ; i < n ; i++){
           ascii[i] = (int)arr[i];
        }

        int target_ascii = (int)target;
        for(int i = 0 ;i < n ; i++){
            if(ascii[i] > target_ascii){
                 return arr[i];
            }
        }
      
      return arr[0];
    }
}