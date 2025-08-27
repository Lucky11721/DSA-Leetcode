class Solution {
     List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums , 0 , list);
        return ans;
    }

    public void helper(int[] arr , int index , List<Integer> list){
        if(index >= arr.length){
            if(ans.contains(list) == false) ans.add(new ArrayList<>(list));
            return;
        }
helper(arr, index+1 , list);
        list.add(arr[index]);
        helper(arr , index +1 , list);
        list.remove(list.size()-1);
        
    }
}