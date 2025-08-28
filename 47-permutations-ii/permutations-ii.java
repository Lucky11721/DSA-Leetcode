class Solution {
     HashMap<Integer,Integer> map = new HashMap<>();
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {


        for(int ele : nums){
            if(map.containsKey(ele)){
                map.put(ele , map.get(ele)+1);
            }
            else{
                map.put(ele , 1);
            }
        }
        Arrays.sort(nums);
        helper(nums , 0);

     return ans;
        
    } 


    public void  helper(int[] arr , int index ){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(index >= arr.length) return;

        int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) {
            next++; // jump over duplicate values
        }
        helper(arr, next);
         if(map.get(arr[index]) > 0){
             list.add(arr[index]);
             map.put(arr[index] , map.get(arr[index]) -1);
            helper(arr , 0);
            list.remove(list.size() -1);
             map.put(arr[index] , map.get(arr[index]) +1);
        }

    }
}