import java.util.*;

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if(n == 0) return 0;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            int sum = minHeight - height[i];
            if(sum > 0){
                ans += sum;
            }
        }

        return ans;
    }
}
