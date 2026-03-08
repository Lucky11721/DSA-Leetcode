class Solution {
    String ans = "";
    HashSet<String> set;
    public String findDifferentBinaryString(String[] nums) {


        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        set = new HashSet<>();
        for(int i = 0 ; i < n ;i++){
            sb.append('0');
            set.add(nums[i]);
        }

        solve(sb , 0 , n);

        return ans;

    }

    public void solve(StringBuilder sb  , int index ,  int n ){

       if(index >= n){
          if(set.contains(sb.toString()) == false){
            ans = sb.toString();
            return;
        }
        else{
            return;
        }
       }

       // not convert
       solve(sb , index+1 , n);
       sb.setCharAt(index , '1');
       solve(sb , index +1 , n);


        
    }
}