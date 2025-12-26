class Solution {
    public int bestClosingTime(String str) {
        int n = str.length();
        int[] pre = new int[n+1];
        int[] suff = new int[n+1];
        int[] ans = new int[n+1];
        for(int i = 1 ; i < pre.length ; i++){
            pre[i] = pre[i-1];
            if(str.charAt(i-1)=='N'){
                pre[i] += 1;
            }
        }
      
         for(int i = n-1 ; i >=0 ; i--){
            char ch =str.charAt(i);
            suff[i] = suff[i+1];
            if(ch == 'Y'){
               suff[i] += 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = pre[i] + suff[i];
            min  = Math.min(min,ans[i]);
        }
        int bestTime = 0;
        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i] == min){
               return i;
            }
        }
      return -1;
    }
}