class Solution {
    public int longestBalanced(int[] nums) {
      

        int ans = 0;

        for(int i = 0 ; i < nums.length ; i++){
          HashSet<Integer> oddInteger = new HashSet<>();
          HashSet<Integer> evenInteger = new HashSet<>();
          int j = i;
            while(j < nums.length){
                if(nums[j] % 2 == 0){
                    evenInteger.add(nums[j]);
                }
                else{
                    oddInteger.add(nums[j]);
                }

                  if(oddInteger.size() == evenInteger.size()){
                ans = Math.max(ans , j - i+1 );
            }
                j++;
            }

          
        }

        return ans;
    }
}