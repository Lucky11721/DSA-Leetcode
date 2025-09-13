class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();

        int[] arr = new int[26];

        for(int  i  = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            arr[ch-'a'] = arr[ch - 'a'] +1;
         }
         int vowelCount =0 ;
         int constCount = 0;

         for(int i = 0 ; i < arr.length ; i++){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20){
                vowelCount =  Math.max(vowelCount , arr[i]); 
            }
            else{
                constCount = Math.max(constCount , arr[i]);
            }
         }


         return vowelCount + constCount;

        
    }
}