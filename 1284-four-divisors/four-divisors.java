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
        int count = 2;
         sum[0] = 1 + n;
        for(int i = 2 ; i*i <=n ; i++){
            if(n %i == 0){
               if(n/i == i){
                count +=1;
                sum[0] += i;
               }
               else{
                count += 2;
                sum[0] = sum[0] + (i + (n/i));
               }
            }
            if(count > 4) return false;
        }

      if(count == 4) return true;
      return false;
    }
}