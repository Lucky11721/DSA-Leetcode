class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int  ans = 0;

        for(int i = 0 ;i < nums.length ; i++){
            int[] sum = new int[1];
            if(divisor(nums[i],sum)){
                ans += sum[0];
            }
        }

        return ans;
    }


    public boolean divisor(int n , int[] sum){
        int count = 0;
         sum[0] = 1 + n;
        for(int i = 2 ; i < n ; i++){
            if(n %i == 0){
                count++;
                if(count > 2) return false;
                sum[0] += i;
            }
        }

      if(count == 2) return true;
      return false;
    }
}