class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] ans = new int[n];

        for(int i = 0 ;i < n ; i++){
            int val = nums.get(i);

            ans[i] = isValid(val);
        }


        return ans;
    }

    int isValid(int n){

        for(int i = 1 ; i <= n ; i++){
            if((i | (i+1)) == n) return i;
        }

        return -1;
    }
}