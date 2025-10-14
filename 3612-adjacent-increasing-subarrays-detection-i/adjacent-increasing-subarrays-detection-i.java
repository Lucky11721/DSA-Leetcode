class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if(k == 1) return true;
        if(n == 2*k){
           return helper(nums, 0, k, k, 2 * k, k);
        }
        for(int i = 0 ; i +2* k <=n ; i++){
            if(helper(nums , i , i+k , i+k , i + 2* k , k)){
                return true;
            }
        }
return false;

    }

    public boolean helper(List<Integer> list , int i , int j , int ik , int jk , int k ){
        int count =0 ;
        for(int x = i +1 ; x < j ; x++){
            if(list.get(x) > list.get(x-1)){
                count++;
            }
            else{
                return false;
            }
        }

        for(int x = ik +1 ; x < jk ; x++){
            if(list.get(x) > list.get(x-1)){
                count++;
            }
            else{
                return false;
            }
        }
        System.out.println(count);
      

      return count == 2*(k-1);

    }
}