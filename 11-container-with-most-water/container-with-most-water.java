class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n-1;

        int ans = 0;

        while(left <=  right){
            int val =Math.min(height[left] , height[right]);
            int area = val *(right - left);

            ans = Math.max(ans , area);
            if(height[left] <=  height[right]){
                left++;
            }
            else{
                right--;
            }
        }
return ans;
    }
}