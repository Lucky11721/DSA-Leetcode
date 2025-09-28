class Solution {
    public int largestPerimeter(int[] arr) {
        int ans = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = n-1; i >= 2  ; i--){
            if(arr[i-1] + arr[i-2] > arr[i]){
                int perimeter = arr[i] + arr[i-1] + arr[i-2];
                 ans = Math.max(ans , perimeter);
            }
        }
        return ans;
    }
}