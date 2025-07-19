class Solution {
    public int minSubArrayLen(int x, int[] arr) {
      int n = arr.length;
        
        int i = 0; 
        int j = 0;
        int sum  = 0;
        int minSize = Integer.MAX_VALUE;
        
        while(j < n && sum < x){
            sum += arr[j];
            j++;
        }
        
        while(i < n){
                if(sum >= x){
                    minSize = Math.min(minSize , j-i);
                    sum = sum - arr[i];
                    i++;
                }
                else if(j < n){
                    sum += arr[j];
                    j++;
                }
                else{
                    break;
                }
            }
        
        
        if(minSize == Integer.MAX_VALUE) return 0;
        
        return minSize;
    }
}
