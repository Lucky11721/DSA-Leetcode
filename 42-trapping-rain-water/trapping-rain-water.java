class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        int i = 0;
        int j = n - 1;

        int maxLeft = arr[0];
        int maxRight = arr[n - 1];

        int ans = 0;
        while (i < j) {
            int trap = 0;
            if (maxLeft <= maxRight) {
                i++;
                trap = maxLeft - arr[i];
                if (maxLeft < arr[i]) {
                    maxLeft = arr[i];
                }
                if (trap > 0) {
                    ans += trap;
                } 
                }
                else {
                    j--;
                    trap = maxRight - arr[j];
                    if (maxRight < arr[j]) {
                        maxRight = arr[j];
                    }
                    if (trap > 0) {
                        ans += trap;
                    }
                }
            }
        
        return ans;
    }
}