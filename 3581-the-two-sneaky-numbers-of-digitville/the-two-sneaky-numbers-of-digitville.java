class Solution {
    public int[] getSneakyNumbers(int[] nums) {
       HashMap<Integer , Integer> map = new HashMap<>();
      
       for(int i = 0 ; i < nums.length ; i++){
        int key  = nums[i];
        if(map.containsKey(key)){
            int freq = map.get(key);
            map.put(nums[i],freq+1);
        }
        else{
            map.put(nums[i],1);
        }
       }
       int count = 0;
       for(int freq : map.values()){
        if(freq > 1){
            count++;
        }
       }
       int[] ans = new int[count];
       int index = 0;
       for(int key : map.keySet()){
          int freq = map.get(key);
          if(freq > 1){
             ans[index] = key;
             index++;
          }
          
       }
      
     return ans;
    }
}