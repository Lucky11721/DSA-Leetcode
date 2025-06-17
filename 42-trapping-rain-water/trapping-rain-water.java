class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n-1;
        int maxLeft = height[0];
        int maxRight = height[n-1];
        int ans = 0;
        while(left < right){
            if(height[left] <= height[right]){
                left++;
                maxLeft = Math.max(maxLeft , height[left]);
                ans += maxLeft - height[left];
            }
            else{
                right--;
                maxRight = Math.max(maxRight , height[right]);
                ans += maxRight - height[right]; 
            }

        }
        return ans;
    }
}