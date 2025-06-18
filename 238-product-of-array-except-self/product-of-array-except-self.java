// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        
       int pre[] = new int[n];
        pre[0] = 1;
        
        for(int i =1 ; i < n ; i++){
            pre[i] = pre[i-1]*arr[i-1];
        }
        
        int suffix[] = new int[n];
          
          
        suffix[n-1] = 1;
        for(int i = n - 2; i >= 0 ; i--){
            suffix[i] = suffix[i+1] * arr[i+1];
        }
        
        
        int answer[] = new int[n];
        
        
        for(int i = 0 ; i < n ; i++){
            answer[i] = pre[i]* suffix[i];
        }
        
        return answer;
        
        
    }
}
