class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        
        Arrays.sort(happiness);

    long ans = 0;

        int i = n-1;
        long decrement = 0;
         while( i >= 0 && k > 0){

            ans += Math.max(happiness[i] - decrement , 0);

            decrement++;
            i--;
            k--;
         }

        return ans;
    }
}