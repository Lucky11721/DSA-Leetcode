class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while( i < j){
              int height = Math.min(arr[i] , arr[j]);
                int len = j - i;
                ans = Math.max(ans , height  * len);
            if(arr[i] > arr[j]){
                j--;
            }
            else{
                i++;
            }
        }

        return ans;
    }
}