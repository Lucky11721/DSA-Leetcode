class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int k = n/2;

        int[] freq = new int[(int)Math.pow(10,4)];

        for(int i = 0 ; i < n ; i++){
            int ele = nums[i];
            freq[ele]++;
            if(freq[ele] > 1) return ele;
        }


        return -1;
    }
}